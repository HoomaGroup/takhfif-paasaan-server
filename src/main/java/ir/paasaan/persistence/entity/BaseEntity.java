package ir.paasaan.persistence.entity;

/**
 * @author Boshra Taheri
 * @since 11/25/2015
 */
public abstract class BaseEntity {
    public abstract void setId(Long id);

    public abstract Long getId();

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BaseEntity)) {
            return false;
        }
        try {
            BaseEntity that = (BaseEntity) obj;
            if (this.getId() != null) {
                return this.getId().equals(that.getId());
            }
        } catch (ClassCastException cce) {
            return false;
        }
        return false;
    }

    @Override
    public int hashCode() {
        if (this.getId() != null) {
            return this.getId().hashCode() + this.getClass().getName().hashCode();
        }

        return this.getClass().getName().hashCode();
    }
}
