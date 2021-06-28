package com.hedgeness.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.hedgeness.app.oauth.service.OAuthClientDetailsService;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {
	
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private OAuthClientDetailsService clientDetailsService;

    @Autowired
    private UserApprovalHandler userApprovalHandler;

    @Autowired
    private JwtTokenStore tokenStore;
    
    @Autowired
	PasswordEncoder passwordEncoder;

    private String privateKey = "-----BEGIN RSA PRIVATE KEY-----\n" +
            "MIIEpAIBAAKCAQEAytpnKPRfOwV5CzxpY7NVfKeBxmqPIQGjn2wievUql8o3DlBZ\n" +
            "WabkDmdIo1kVTbt/IbjCA1Al/XIl5T4FLdzESZIUfal+dpvxXxbwAfaRXUGGTBPa\n" +
            "ecH3ow8xFAqNn9gIyb/AJ9mjYR+apUSW5GPfq3HgURHlQNl1KK1+t/UGjRv2DbBd\n" +
            "8t7xGeI0gVYHp7czd6xmQHefZsE2BO5u0Iv+f3rRHfizCPwt91tt1zyVcXZQfK80\n" +
            "l3Y7wHpq9uM5w++VXIEGL2XelCMpzEs6Ul7e2qjgegJOPSepkI7G9nFecgkIdsqE\n" +
            "jjddEaR2mM7w27lhFx+ApjNDrVhYm8+WQYE9hwIDAQABAoIBAH0r96wV3w2UevSr\n" +
            "+nxDFOUul63P4zICyOx+1Wf6EKZJaV+zxO7FRMR+hxwExFiK8g/k6hMRSd/yp9+l\n" +
            "PZznNVgQhARmqlqWL4L1rHQJqflZjX00YwPu5NgBb89mE64mqIWVhQUSDvbHga2p\n" +
            "fVLBLiukwT5FRKmXhevr4t2wnLJFDS90EWZgw6Eui7LEvKBwq8mdO5WrWVsHkxhn\n" +
            "N9JnKhSyHcSwV779fU6pgtyrsJ7Fw7ZL+1nWiPngDhGXbQZFrJJ5O43KlPgfBLMN\n" +
            "sJLWCjQ1xlSN0M/Ovj9I6kCqPAiI6pBut4ZjhMfm/1DCMYV6Ll/pya05RA+ocRa4\n" +
            "N9cd2kECgYEA7pIz9gmXhCUVZ5DQvMdz7BlHp7zpnjV+I9pmZ2XAEzk7phZzNPYB\n" +
            "0kjcaYdeRbJYQLvY9J9zgNQI6tjA88uOBneNIoCCE/rZN2Na2N+wkgH4iBD9OoOZ\n" +
            "A4nLji+RksvI/buI1x1Sl1CYKjHJarOi/63ogyZujzw+VIJCb8Y9+9MCgYEA2awy\n" +
            "T1V9Pw+6b9l5svcRuSYfbofDyyqsKrpkrcTYmh63/Iv29Ig73OVmi/H8TyyEMU3H\n" +
            "MtDAHe2NDPH9NiIx75IdYODv07KI0J4zQcr106THrPgcScagO+Qtw8gco3jXv56V\n" +
            "pMyjrR62qoyWzd561OoMpIaWJ+beWppt6aneav0CgYEAjY/jlVMLvTXkBZhAxEP1\n" +
            "3VsC0d2fImnLd6rYqPIPj1ietGcN5Zc0bXsejt/saJ7zDzZn/n+/Ieqvf+suU3ut\n" +
            "wtidvqNSjFiFHACwn4/cTkctGlA6csYzvY2+Y5iGYPzbPvRQtpSHtZH1ONRiGBaP\n" +
            "2fdvyKK9Z/Dva2X/1iNkFFECgYApauBvw/5+30lEOwczDFvs9NoKN/8DS21S/ABo\n" +
            "KApm2O19OkyVHs71KxkmC7dMgVXt47TBcIL9rtOl4O2jPUJvKUg5xNMdXt01hMSQ\n" +
            "AkRgLvxnZxZK22ZlvvcOR6dbW4UByvUCVIXYTP3I2dNf/LM2jAo3y/wKP52Tc8ry\n" +
            "KQZPKQKBgQCRhCpK0aYhWSi5qLaSEw7xh+HAOACUGNiMDQ/OsQw4C5WgbQP6Juim\n" +
            "t2MB/618WvLomqOkyZlYvVNzpGy4m3R3qPVAweqClapscPQw8GUnGZpSW9v6ePJ4\n" +
            "ptSMQsTenppdXQKMyXURzu7MavcqYVwyj/BfYgnHmMCowIWvFItvrA==\n" +
            "-----END RSA PRIVATE KEY-----\n";
    private String publicKey = "-----BEGIN PUBLIC KEY-----\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAytpnKPRfOwV5CzxpY7NV\n" +
            "fKeBxmqPIQGjn2wievUql8o3DlBZWabkDmdIo1kVTbt/IbjCA1Al/XIl5T4FLdzE\n" +
            "SZIUfal+dpvxXxbwAfaRXUGGTBPaecH3ow8xFAqNn9gIyb/AJ9mjYR+apUSW5GPf\n" +
            "q3HgURHlQNl1KK1+t/UGjRv2DbBd8t7xGeI0gVYHp7czd6xmQHefZsE2BO5u0Iv+\n" +
            "f3rRHfizCPwt91tt1zyVcXZQfK80l3Y7wHpq9uM5w++VXIEGL2XelCMpzEs6Ul7e\n" +
            "2qjgegJOPSepkI7G9nFecgkIdsqEjjddEaR2mM7w27lhFx+ApjNDrVhYm8+WQYE9\n" +
            "hwIDAQAB\n" +
            "-----END PUBLIC KEY-----\n";

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
       security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()").realm("WEB_APP_REALM");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    	
    	clients.withClientDetails(clientDetailsService);
    	
    /*	clients.inMemory().withClient(clientId)
  		.secret(clientSecret).scopes("read", "write")
  		.resourceIds(resourceId)
  		.authorizedGrantTypes("password", "refresh_token").accessTokenValiditySeconds(accessTokenValiditySeconds)
  		.refreshTokenValiditySeconds(accessTokenValiditySeconds); */
 }
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.tokenStore(tokenStore).userApprovalHandler(userApprovalHandler)
                .authenticationManager(authenticationManager).accessTokenConverter(tokenEnhancer());
    }

    @Bean
    public JwtTokenStore tokenStore() {
        return new JwtTokenStore(tokenEnhancer());
    }

    @Bean
    public JwtAccessTokenConverter tokenEnhancer() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
    //    converter.setSigningKey(privateKey);
     //   converter.setVerifierKey(publicKey);
        return converter;
    }


    @Bean
    public UserApprovalHandler userApprovalHandler(){
        TokenStoreUserApprovalHandler handler = new TokenStoreUserApprovalHandler();
        handler.setTokenStore(tokenStore());
        handler.setRequestFactory(new DefaultOAuth2RequestFactory(clientDetailsService));
        handler.setClientDetailsService(clientDetailsService);
        return handler;
    }

    @Bean
    public ApprovalStore approvalStore() {
        TokenApprovalStore store = new TokenApprovalStore();
        store.setTokenStore(tokenStore());
        return store;
    }

}
