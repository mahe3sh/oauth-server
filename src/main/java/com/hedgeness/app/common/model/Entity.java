package com.hedgeness.app.common.model;

import java.util.Date;

public interface Entity {
    public String getId() ;
    public void setId(String id);
    public String getCreatedBy();
    public void setCreatedBy(String createdBy);
    public Date getCreatedAt();
    public void setCreatedAt(Date createdAt);
    public Date getUpdatedAt();
    public void setUpdatedAt(Date updatedAt);
    public String getUpdatedBy();
    public void setUpdatedBy(String updatedBy);
    public String getOrganizationId();
    public void setOrganizationId(String organizationId);
}
