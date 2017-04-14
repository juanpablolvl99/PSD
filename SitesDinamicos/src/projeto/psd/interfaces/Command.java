package projeto.psd.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {

    public void execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, IOException;
    
}
