package com.sasaj.lastfmapp.domain.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Contains common fields for all database models.
 */

abstract class BaseModel implements Serializable {

    /**
     * Entity creation timestamp. Updated via database trigger.
     */
    private Date created;

    /**
     * Entity last update timestamp. Updated via database trigger.
     */
    private Date updated;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
