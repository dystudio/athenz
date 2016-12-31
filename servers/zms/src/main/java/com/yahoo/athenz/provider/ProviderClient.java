//
// This file generated by rdl 1.4.8. Do not modify!
//
package com.yahoo.athenz.provider;

import com.yahoo.rdl.*;
import javax.ws.rs.client.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.net.ssl.HostnameVerifier;

public class ProviderClient {
    Client client;
    WebTarget base;
    String credsHeader;
    String credsToken;

    public ProviderClient(String url) {
        client = ClientBuilder.newClient();
        base = client.target(url);
    }

    public ProviderClient(String url, HostnameVerifier hostnameVerifier) {
        client = ClientBuilder.newBuilder()
            .hostnameVerifier(hostnameVerifier)
            .build();
        base = client.target(url);
    }

    public void close() {
        client.close();
    }

    public ProviderClient setProperty(String name, Object value) {
        client = client.property(name, value);
        return this;
    }

    public ProviderClient addCredentials(String header, String token) {
        credsHeader = header;
        credsToken = token;
        return this;
    }

    public Tenant putTenant(String service, String tenant, String auditRef, Tenant template) {
        WebTarget target = base.path("/service/{service}/tenant/{tenant}")
            .resolveTemplate("service", service)
            .resolveTemplate("tenant", tenant);
        Invocation.Builder invocationBuilder = target.request("application/json");
        if (credsHeader != null) {
            invocationBuilder = invocationBuilder.header(credsHeader, credsToken);
        }
        if (auditRef != null) {
            invocationBuilder = invocationBuilder.header("Y-Audit-Ref", auditRef);
        }
        Response response = invocationBuilder.put(javax.ws.rs.client.Entity.entity(template, "application/json"));
        int code = response.getStatus();
        switch (code) {
        case 200:
            return response.readEntity(Tenant.class);
        default:
            throw new ResourceException(code, response.readEntity(ResourceError.class));
        }

    }

    public Tenant getTenant(String service, String tenant) {
        WebTarget target = base.path("/service/{service}/tenant/{tenant}")
            .resolveTemplate("service", service)
            .resolveTemplate("tenant", tenant);
        Invocation.Builder invocationBuilder = target.request("application/json");
        if (credsHeader != null) {
            invocationBuilder = invocationBuilder.header(credsHeader, credsToken);
        }
        Response response = invocationBuilder.get();
        int code = response.getStatus();
        switch (code) {
        case 200:
            return response.readEntity(Tenant.class);
        default:
            throw new ResourceException(code, response.readEntity(ResourceError.class));
        }

    }

    public Tenant deleteTenant(String service, String tenant, String auditRef) {
        WebTarget target = base.path("/service/{service}/tenant/{tenant}")
            .resolveTemplate("service", service)
            .resolveTemplate("tenant", tenant);
        Invocation.Builder invocationBuilder = target.request("application/json");
        if (credsHeader != null) {
            invocationBuilder = invocationBuilder.header(credsHeader, credsToken);
        }
        if (auditRef != null) {
            invocationBuilder = invocationBuilder.header("Y-Audit-Ref", auditRef);
        }
        Response response = invocationBuilder.delete();
        int code = response.getStatus();
        switch (code) {
        case 204:
            return null;
        default:
            throw new ResourceException(code, response.readEntity(ResourceError.class));
        }

    }

    public TenantResourceGroup putTenantResourceGroup(String service, String tenant, String resourceGroup, String auditRef, TenantResourceGroup template) {
        WebTarget target = base.path("/service/{service}/tenant/{tenant}/resourceGroup/{resourceGroup}")
            .resolveTemplate("service", service)
            .resolveTemplate("tenant", tenant)
            .resolveTemplate("resourceGroup", resourceGroup);
        Invocation.Builder invocationBuilder = target.request("application/json");
        if (credsHeader != null) {
            invocationBuilder = invocationBuilder.header(credsHeader, credsToken);
        }
        if (auditRef != null) {
            invocationBuilder = invocationBuilder.header("Y-Audit-Ref", auditRef);
        }
        Response response = invocationBuilder.put(javax.ws.rs.client.Entity.entity(template, "application/json"));
        int code = response.getStatus();
        switch (code) {
        case 200:
            return response.readEntity(TenantResourceGroup.class);
        default:
            throw new ResourceException(code, response.readEntity(ResourceError.class));
        }

    }

    public TenantResourceGroup deleteTenantResourceGroup(String service, String tenant, String resourceGroup, String auditRef) {
        WebTarget target = base.path("/service/{service}/tenant/{tenant}/resourceGroup/{resourceGroup}")
            .resolveTemplate("service", service)
            .resolveTemplate("tenant", tenant)
            .resolveTemplate("resourceGroup", resourceGroup);
        Invocation.Builder invocationBuilder = target.request("application/json");
        if (credsHeader != null) {
            invocationBuilder = invocationBuilder.header(credsHeader, credsToken);
        }
        if (auditRef != null) {
            invocationBuilder = invocationBuilder.header("Y-Audit-Ref", auditRef);
        }
        Response response = invocationBuilder.delete();
        int code = response.getStatus();
        switch (code) {
        case 204:
            return null;
        default:
            throw new ResourceException(code, response.readEntity(ResourceError.class));
        }

    }

}