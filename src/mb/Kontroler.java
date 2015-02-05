/**
 * 
 */
package mb;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.drools.KnowledgeBase;
import org.drools.agent.KnowledgeAgent;
import org.drools.agent.KnowledgeAgentFactory;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.goodoldai.jeff.wizard.JEFFWizard;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import domen.Dom;
import domen.TrenutniKorisnik;

/**
 * @author Rus
 * 
 */
@ManagedBean(name = "kontroler")
@SessionScoped
public class Kontroler {

	private Dom dom;
	private JEFFWizard pdf;
	
	public Kontroler() {

	}

	public String pocetna() {
		TrenutniKorisnik.vratiObjekat().setDom(new Dom());
		return "/index.xhtml?faces-redirect=true";
	}

	public String prvoPitanje() {

		dom = new Dom();
		return "/pitanja/prvoPitanje.xhtml?faces-redirect=true";

	}

	public String odgovorNaPrvoPitanje() {

		TrenutniKorisnik.vratiObjekat().setPitanje(1);
		TrenutniKorisnik.vratiObjekat().setOdabrano(false);

		if (dom.getInvaliditet() == 0) {
			TrenutniKorisnik.vratiObjekat().setOdgovor('a');
			// TrenutniKorisnik.vratiObjekat().getDom().setInvaliditet(0);
			TrenutniKorisnik.vratiObjekat().setOdabrano(true);
			return "/pitanja/sestoPitanje.xhtml?faces-redirect=true";
		}

		if (dom.getInvaliditet() == 1) {
			TrenutniKorisnik.vratiObjekat().setOdgovor('b');
			TrenutniKorisnik.vratiObjekat().getDom().setInvaliditet(1);
			TrenutniKorisnik.vratiObjekat().setOdabrano(true);
			return "/pitanja/drugoPitanje.xhtml?faces-redirect=true";
		}
		return null;

	}

	public String drugoPitanje() {

		dom = new Dom();
		return "/pitanja/drugoPitanje.xhtml?faces-redirect=true";

	}

	public String odgovorNaDrugoPitanje() {

		TrenutniKorisnik.vratiObjekat().setPitanje(2);
		TrenutniKorisnik.vratiObjekat().setOdabrano(false);

		if (dom.getPol() == 0) {
			TrenutniKorisnik.vratiObjekat().setOdgovor('a');
			// TrenutniKorisnik.vratiObjekat().getDom().setInvaliditet(0);
			TrenutniKorisnik.vratiObjekat().setOdabrano(true);
			return "/pitanja/cetvrtoPitanje.xhtml?faces-redirect=true";
		}

		if (dom.getPol() == 1) {
			TrenutniKorisnik.vratiObjekat().setOdgovor('b');
			TrenutniKorisnik.vratiObjekat().getDom().setPol(1);
			TrenutniKorisnik.vratiObjekat().setOdabrano(true);
			return "/pitanja/trecePitanje.xhtml?faces-redirect=true";
		}
		return null;

	}

	public String trecePitanje() {

		dom = new Dom();
		return "/pitanja/trecePitanje.xhtml?faces-redirect=true";

	}

	public String odgovorNaTrecePitanje() {

		TrenutniKorisnik.vratiObjekat().setPitanje(3);
		TrenutniKorisnik.vratiObjekat().setOdabrano(false);

		if (dom.getOdvojenostOdMuskaraca() == 0) {
			TrenutniKorisnik.vratiObjekat().setOdgovor('a');
			// TrenutniKorisnik.vratiObjekat().getDom().setInvaliditet(0);
			TrenutniKorisnik.vratiObjekat().setOdabrano(true);
			return "/pitanja/cetvrtoPitanje.xhtml?faces-redirect=true";
		}

		if (dom.getOdvojenostOdMuskaraca() == 1) {
			TrenutniKorisnik.vratiObjekat().setOdgovor('b');
			TrenutniKorisnik.vratiObjekat().getDom()
					.setOdvojenostOdMuskaraca(1);
			TrenutniKorisnik.vratiObjekat().setOdabrano(true);
			return "/pitanja/cetvrtoPitanje.xhtml?faces-redirect=true";
		}
		return null;

	}

	public String cetvrtoPitanje() {

		dom = new Dom();
		return "/pitanja/cetvrtoPitanje.xhtml?faces-redirect=true";

	}

	public String odgovorNaCetvrtoPitanje() {

		TrenutniKorisnik.vratiObjekat().setPitanje(4);
		TrenutniKorisnik.vratiObjekat().setOdabrano(false);

		if (dom.getMesto() == 0) {
			TrenutniKorisnik.vratiObjekat().setOdgovor('a');
			// TrenutniKorisnik.vratiObjekat().getDom().setInvaliditet(0);
			TrenutniKorisnik.vratiObjekat().setOdabrano(true);
			return "/pitanja/petoPitanje.xhtml?faces-redirect=true";
		}

		if (dom.getMesto() == 1) {
			TrenutniKorisnik.vratiObjekat().setOdgovor('b');
			TrenutniKorisnik.vratiObjekat().getDom().setMesto(1);
			TrenutniKorisnik.vratiObjekat().setOdabrano(true);
			return "/pitanja/petoPitanje.xhtml?faces-redirect=true";
		}

		if (dom.getMesto() == 2) {
			TrenutniKorisnik.vratiObjekat().setOdgovor('c');
			TrenutniKorisnik.vratiObjekat().getDom().setMesto(2);
			TrenutniKorisnik.vratiObjekat().setOdabrano(true);
			return "/pitanja/petoPitanje.xhtml?faces-redirect=true";
		}
		return null;

	}

	public String petoPitanje() {

		dom = new Dom();
		return "/pitanja/petoPitanje.xhtml?faces-redirect=true";

	}

	public String odgovorNaPetoPitanje() {

		TrenutniKorisnik.vratiObjekat().setPitanje(5);
		TrenutniKorisnik.vratiObjekat().setOdabrano(false);

		if (dom.getLift() == 0) {
			TrenutniKorisnik.vratiObjekat().setOdgovor('a');
			// TrenutniKorisnik.vratiObjekat().getDom().setInvaliditet(0);
			TrenutniKorisnik.vratiObjekat().setOdabrano(true);
			return "/pitanja/sestoPitanje.xhtml?faces-redirect=true";
		}

		if (dom.getLift() == 1) {
			TrenutniKorisnik.vratiObjekat().setOdgovor('b');
			TrenutniKorisnik.vratiObjekat().getDom().setLift(1);
			TrenutniKorisnik.vratiObjekat().setOdabrano(true);
			return "/pitanja/sestoPitanje.xhtml?faces-redirect=true";
		}
		return null;

	}

	public String sestoPitanje() {

		dom = new Dom();
		return "/pitanja/sestoPitanje.xhtml?faces-redirect=true";

	}

	public String odgovorNaSestoPitanje() {

		TrenutniKorisnik.vratiObjekat().setPitanje(6);
		TrenutniKorisnik.vratiObjekat().setOdabrano(false);

		if (dom.getDrustveniZivot() == 0) {
			TrenutniKorisnik.vratiObjekat().setOdgovor('a');
			// TrenutniKorisnik.vratiObjekat().getDom().setInvaliditet(0);
			TrenutniKorisnik.vratiObjekat().setOdabrano(true);
			return "/pitanja/sedmoPitanje.xhtml?faces-redirect=true";
		}

		if (dom.getDrustveniZivot() == 1) {
			TrenutniKorisnik.vratiObjekat().setOdgovor('b');
			TrenutniKorisnik.vratiObjekat().getDom().setDrustveniZivot(1);
			TrenutniKorisnik.vratiObjekat().setOdabrano(true);
			return "/pitanja/sedmoPitanje.xhtml?faces-redirect=true";
		}
		return null;

	}

	public String sedmoPitanje() {

		dom = new Dom();
		return "/pitanja/sedmoPitanje.xhtml?faces-redirect=true";

	}

	public String odgovorNaSedmoPitanje() {

		TrenutniKorisnik.vratiObjekat().setPitanje(7);
		TrenutniKorisnik.vratiObjekat().setOdabrano(false);

		if (dom.getKupatilo() == 0) {
			TrenutniKorisnik.vratiObjekat().setOdgovor('a');
			// TrenutniKorisnik.vratiObjekat().getDom().setInvaliditet(0);
			TrenutniKorisnik.vratiObjekat().setOdabrano(true);
			return "/pitanja/osmoPitanje.xhtml?faces-redirect=true";
		}

		if (dom.getKupatilo() == 1) {
			TrenutniKorisnik.vratiObjekat().setOdgovor('b');
			TrenutniKorisnik.vratiObjekat().getDom().setKupatilo(1);
			TrenutniKorisnik.vratiObjekat().setOdabrano(true);
			return "/pitanja/osmoPitanje.xhtml?faces-redirect=true";
		}
		return null;

	}

	public String osmoPitanje() {

		dom = new Dom();
		return "/pitanja/osmoPitanje.xhtml?faces-redirect=true";

	}

	public String odgovorNaOsmoPitanje() {

		TrenutniKorisnik.vratiObjekat().setPitanje(8);
		TrenutniKorisnik.vratiObjekat().setOdabrano(false);

		if (dom.getMenza() == 0) {
			TrenutniKorisnik.vratiObjekat().setOdgovor('a');
			// TrenutniKorisnik.vratiObjekat().getDom().setInvaliditet(0);
			TrenutniKorisnik.vratiObjekat().setOdabrano(true);
			return "/pitanja/devetoPitanje.xhtml?faces-redirect=true";
		}

		if (dom.getMenza() == 1) {
			TrenutniKorisnik.vratiObjekat().setOdgovor('b');
			TrenutniKorisnik.vratiObjekat().getDom().setMenza(1);
			TrenutniKorisnik.vratiObjekat().setOdabrano(true);
			return "/pitanja/devetoPitanje.xhtml?faces-redirect=true";
		}
		return null;

	}

	public String devetoPitanje() {

		dom = new Dom();
		return "/pitanja/devetoPitanje.xhtml?faces-redirect=true";

	}

	public String odgovorNaDevetoPitanje() {

		TrenutniKorisnik.vratiObjekat().setPitanje(9);
		TrenutniKorisnik.vratiObjekat().setOdabrano(false);

		if (dom.getBrojKreveta() == 0) {
			TrenutniKorisnik.vratiObjekat().setOdgovor('a');
			// TrenutniKorisnik.vratiObjekat().getDom().setInvaliditet(0);
			TrenutniKorisnik.vratiObjekat().setOdabrano(true);
			return "/pitanja/desetoPitanje.xhtml?faces-redirect=true";
		}

		if (dom.getBrojKreveta() == 1) {
			TrenutniKorisnik.vratiObjekat().setOdgovor('b');
			TrenutniKorisnik.vratiObjekat().getDom().setBrojKreveta(1);
			TrenutniKorisnik.vratiObjekat().setOdabrano(true);
			return "/pitanja/desetoPitanje.xhtml?faces-redirect=true";
		}

		if (dom.getBrojKreveta() == 2) {
			TrenutniKorisnik.vratiObjekat().setOdgovor('b');
			TrenutniKorisnik.vratiObjekat().getDom().setBrojKreveta(2);
			TrenutniKorisnik.vratiObjekat().setOdabrano(true);
			return "/pitanja/desetoPitanje.xhtml?faces-redirect=true";
		}
		return null;

	}

	public String desetoPitanje() {

		dom = new Dom();
		return "/pitanja/desetoPitanje.xhtml?faces-redirect=true";

	}

	public String odgovorNaDesetoPitanje() {

		TrenutniKorisnik.vratiObjekat().setPitanje(10);
		TrenutniKorisnik.vratiObjekat().setOdabrano(false);

		if (dom.getKategorijaSobe() == 0) {
			TrenutniKorisnik.vratiObjekat().setOdgovor('a');
			// TrenutniKorisnik.vratiObjekat().getDom().setInvaliditet(0);
			TrenutniKorisnik.vratiObjekat().setOdabrano(true);
			return "/kraj.xhtml?faces-redirect=true";
		}

		if (dom.getKategorijaSobe() == 1) {
			TrenutniKorisnik.vratiObjekat().setOdgovor('b');
			TrenutniKorisnik.vratiObjekat().getDom().setKategorijaSobe(1);
			TrenutniKorisnik.vratiObjekat().setOdabrano(true);
			return "/kraj.xhtml?faces-redirect=true";
		}

		if (dom.getKategorijaSobe() == 2) {
			TrenutniKorisnik.vratiObjekat().setOdgovor('b');
			TrenutniKorisnik.vratiObjekat().getDom().setKategorijaSobe(2);
			TrenutniKorisnik.vratiObjekat().setOdabrano(true);
			return "/kraj.xhtml?faces-redirect=true";
		}
		return null;

	}

	public String generisanjeIzvestaja() throws IOException {

		System.out.println("invaliditet: " + dom.getInvaliditet());
		System.out.println("pol: " + dom.getPol());
		System.out.println("odvojenost: " + dom.getOdvojenostOdMuskaraca());
		System.out.println("lokacija: " + dom.getMesto());
		System.out.println("lift: " + dom.getLift());
		System.out.println("drustveni zivot: " + dom.getDrustveniZivot());
		System.out.println("kupatila: " + dom.getKupatilo());
		System.out.println("menza: " + dom.getMenza());
		System.out.println("broj kreveta: " + dom.getBrojKreveta());
		System.out.println("kategorija sobe: " + dom.getKategorijaSobe());

		bazaZnanja();
		Document doc = new Document();
		FacesContext.getCurrentInstance().getExternalContext().responseReset();
		FacesContext.getCurrentInstance().responseComplete();
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

		try {
			
			response.setContentType("application/pdf");
			PdfWriter.getInstance(doc, response.getOutputStream());
	        doc.open();
	        Paragraph naslov = new Paragraph("NAS PREDLOG");
	        naslov.setAlignment(Element.ALIGN_CENTER);
	        naslov.setSpacingAfter(20);
	        Paragraph opis = new Paragraph(dom.getOpis());
	        opis.setSpacingBefore(20);
	        Image slika = Image.getInstance(dom.getSlika());
	        slika.setAlignment(Image.ALIGN_CENTER);
	        slika.scaleAbsolute(468, 312);
	        doc.add(naslov);
	        doc.add(slika);
	        doc.add(opis);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		doc.close();
		return "/index.xhtml?faces-redirect=true";

	}
	
	
	/**
	 * 
	 */
	private void bazaZnanja() {
		
		StatefulKnowledgeSession ksession = null;

		try {

			// ucitavanje baze znanja

			KnowledgeBase kbase = readKnowledgeBase();
			
			ksession = kbase.newStatefulKnowledgeSession();
			KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");
			
			ksession.insert(dom);
			ksession.fireAllRules();
			
			System.out.println(dom.getOpis());
			System.out.println("get slika:  " + dom.getSlika());
			
			logger.close();

		} catch (Throwable t) {
			t.printStackTrace();
		}

	}

	private static KnowledgeBase readKnowledgeBase() throws Exception {

		KnowledgeAgent kagent = KnowledgeAgentFactory.newKnowledgeAgent("agentDom");
		kagent.applyChangeSet(ResourceFactory.newClassPathResource("ChangeSet.xml"));
		KnowledgeBase kbase = kagent.getKnowledgeBase();
		kagent.dispose();
		return kbase;
		
	}

	/**
	 * @return the dom
	 */
	public Dom getDom() {
		return dom;
	}

	/**
	 * @param dom
	 *            the dom to set
	 */
	public void setDom(Dom dom) {
		this.dom = dom;
	}

	/**
	 * @return the pdf
	 */
	public JEFFWizard getPdf() {
		return pdf;
	}

	/**
	 * @param pdf
	 *            the pdf to set
	 */
	public void setPdf(JEFFWizard pdf) {
		this.pdf = pdf;
	}

}
