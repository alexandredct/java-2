package manager;

import java.io.InputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.engine.spi.SessionImplementor;
import com.mysql.jdbc.Connection;
import net.sf.jasperreports.engine.JasperRunManager;
import persistence.HibernateUtil;

@ManagedBean(name="mb")
@RequestScoped
public class ManagerBean {

	public void relatorio() {
		FacesContext fc = FacesContext.getCurrentInstance();
		
		SessionImplementor sim = (SessionImplementor) HibernateUtil.getSessionFactory().openSession();
        Connection con = (Connection) sim.connection();
		try {
			
			
			InputStream arquivo = fc.getExternalContext().getResourceAsStream("/projetoRelatorio.jasper");
			byte[] report = JasperRunManager.runReportToPdf(arquivo,null, con);
			HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
			ServletOutputStream out = response.getOutputStream(); 
		    out.write(report);
		    out.flush();
		    
		} catch (Exception e) {

			e.printStackTrace();
			
		}
	}
}
