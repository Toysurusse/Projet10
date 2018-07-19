package action.privacy;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;


public class Connect extends ActionSupport implements SessionAware {

    public String execute() throws Exception {

        return SUCCESS;
    }

    public String input() throws Exception {

        return SUCCESS;
    }

    /**
     * MapString to import session
     */
    protected Map<String, Object> map;

    @Override
    public void setSession(Map<String, Object> map) {
        this.map = map;
    }

    public Map<String, Object> getSession() {
        return map;
    }
}
