package net.czqu.taskmaster.dao.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class AccessLog implements Cloneable {
    private Integer id;

    private Byte appId;

    private String protocol;

    private String hostName;

    private String requestUri;

    private String params;

    private String method;

    private Integer statusCode;

    private Integer uid;

    private String userName;

    private String remoteIp;

    private String userAgent;

    private Integer costTime;

    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getAppId() {
        return appId;
    }

    public void setAppId(Byte appId) {
        this.appId = appId;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol == null ? null : protocol.trim();
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName == null ? null : hostName.trim();
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri == null ? null : requestUri.trim();
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getRemoteIp() {
        return remoteIp;
    }

    public void setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp == null ? null : remoteIp.trim();
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent == null ? null : userAgent.trim();
    }

    public Integer getCostTime() {
        return costTime;
    }

    public void setCostTime(Integer costTime) {
        this.costTime = costTime;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public AccessLog clone() throws CloneNotSupportedException {
        return (AccessLog) super.clone();
    }

    public static class Builder {
        private AccessLog obj;

        public Builder() {
            this.obj = new AccessLog();
        }

        public Builder id(Integer id) {
            obj.setId(id);
            return this;
        }

        public Builder appId(Byte appId) {
            obj.setAppId(appId);
            return this;
        }

        public Builder protocol(String protocol) {
            obj.setProtocol(protocol);
            return this;
        }

        public Builder hostName(String hostName) {
            obj.setHostName(hostName);
            return this;
        }

        public Builder requestUri(String requestUri) {
            obj.setRequestUri(requestUri);
            return this;
        }

        public Builder params(String params) {
            obj.setParams(params);
            return this;
        }

        public Builder method(String method) {
            obj.setMethod(method);
            return this;
        }

        public Builder statusCode(Integer statusCode) {
            obj.setStatusCode(statusCode);
            return this;
        }

        public Builder uid(Integer uid) {
            obj.setUid(uid);
            return this;
        }

        public Builder userName(String userName) {
            obj.setUserName(userName);
            return this;
        }

        public Builder remoteIp(String remoteIp) {
            obj.setRemoteIp(remoteIp);
            return this;
        }

        public Builder userAgent(String userAgent) {
            obj.setUserAgent(userAgent);
            return this;
        }

        public Builder costTime(Integer costTime) {
            obj.setCostTime(costTime);
            return this;
        }

        public Builder time(Date time) {
            obj.setTime(time);
            return this;
        }

        public AccessLog build() {
            return this.obj;
        }
    }

    public enum Column {
        id("id", "id", "INTEGER", false),
        appId("app_id", "appId", "TINYINT", false),
        protocol("protocol", "protocol", "VARCHAR", false),
        hostName("host_name", "hostName", "VARCHAR", false),
        requestUri("request_uri", "requestUri", "VARCHAR", false),
        params("params", "params", "VARCHAR", false),
        method("method", "method", "VARCHAR", false),
        statusCode("status_code", "statusCode", "INTEGER", false),
        uid("uid", "uid", "INTEGER", false),
        userName("user_name", "userName", "VARCHAR", false),
        remoteIp("remote_ip", "remoteIp", "VARCHAR", false),
        userAgent("user_agent", "userAgent", "VARCHAR", false),
        costTime("cost_time", "costTime", "INTEGER", false),
        time("time", "time", "TIMESTAMP", false);

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