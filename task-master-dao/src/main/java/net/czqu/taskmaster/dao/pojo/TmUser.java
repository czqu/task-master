package net.czqu.taskmaster.dao.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class TmUser implements Cloneable {
    private Integer id;

    private Integer uid;

    private String username;

    private String password;

    private String email;

    private String phone;

    private Date createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public TmUser clone() throws CloneNotSupportedException {
        return (TmUser) super.clone();
    }

    public static class Builder {
        private TmUser obj;

        public Builder() {
            this.obj = new TmUser();
        }

        public Builder id(Integer id) {
            obj.setId(id);
            return this;
        }

        public Builder uid(Integer uid) {
            obj.setUid(uid);
            return this;
        }

        public Builder username(String username) {
            obj.setUsername(username);
            return this;
        }

        public Builder password(String password) {
            obj.setPassword(password);
            return this;
        }

        public Builder email(String email) {
            obj.setEmail(email);
            return this;
        }

        public Builder phone(String phone) {
            obj.setPhone(phone);
            return this;
        }

        public Builder createdAt(Date createdAt) {
            obj.setCreatedAt(createdAt);
            return this;
        }

        public TmUser build() {
            return this.obj;
        }
    }

    public enum Column {
        id("id", "id", "INTEGER", false),
        uid("uid", "uid", "INTEGER", false),
        username("username", "username", "VARCHAR", false),
        password("password", "password", "VARCHAR", false),
        email("email", "email", "VARCHAR", false),
        phone("phone", "phone", "VARCHAR", false),
        createdAt("created_at", "createdAt", "TIMESTAMP", false);

        private static final String BEGINNING_DELIMITER = "\"";

        private static final String ENDING_DELIMITER = "\"";

        private final String column;

        private final boolean isColumnNameDelimited;

        private final String javaProperty;

        private final String jdbcType;

        public String value() {
            return this.column;
        }

        public String getValue() {
            return this.column;
        }

        public String getJavaProperty() {
            return this.javaProperty;
        }

        public String getJdbcType() {
            return this.jdbcType;
        }

        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        public static Column[] all() {
            return Column.values();
        }

        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }

        public String getAliasedEscapedColumnName() {
            return this.getEscapedColumnName();
        }
    }
}