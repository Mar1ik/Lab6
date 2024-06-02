package server.resources;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public enum OrganizationType {
    COMMERCIAL,
    GOVERNMENT,
    TRUST;
}
