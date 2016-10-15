package infrastructure.identity;

import java.util.Date;
import java.util.Map;

/**
 * Created by bruenni on 15.10.16.
 */
public class Jwt {
    private String subject;
    private Date iat;
    private Date exp;
    private Map<String, Object> claims;

    /**
     * Constructor.
     *
     * @param
     */
    public Jwt(String  subject, Date iat, Date exp, Map<String, Object> claims) {
        this.subject = subject;
        this.iat = iat;
        this.exp = exp;
        this.claims = claims;
    }

    public String getSubject() {
        return subject;
    }

    public Date getIat() {
        return iat;
    }

    public Date getExp() {
        return exp;
    }

    public Map<String, Object> getClaims() {
        return claims;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jwt jwt = (Jwt) o;

        if (subject != null ? !subject.equals(jwt.subject) : jwt.subject != null) return false;
        if (iat != null ? !iat.equals(jwt.iat) : jwt.iat != null) return false;
        if (exp != null ? !exp.equals(jwt.exp) : jwt.exp != null) return false;
        return claims != null ? claims.equals(jwt.claims) : jwt.claims == null;

    }

    @Override
    public int hashCode() {
        int result = subject != null ? subject.hashCode() : 0;
        result = 31 * result + (iat != null ? iat.hashCode() : 0);
        result = 31 * result + (exp != null ? exp.hashCode() : 0);
        result = 31 * result + (claims != null ? claims.hashCode() : 0);
        return result;
    }
}
