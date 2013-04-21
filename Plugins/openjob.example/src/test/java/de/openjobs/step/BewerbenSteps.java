package de.openjobs.step;

import junit.framework.Assert;

import org.jbehave.core.annotations.AsParameterConverter;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import de.openjobs.entities.Arbeitgeber;
import de.openjobs.entities.Stellenangebot;

public class BewerbenSteps {

	private final static Arbeitgeber ARBEITGEBER = new Arbeitgeber();
	private final static Stellenangebot STELLENANGEBOT = ARBEITGEBER.erstelleStellenangebot();
	
	
	public BewerbenSteps() {
		super();
	}

	@AsParameterConverter
	public Arbeitgeber erstelleArbeitgeber(String tokenName) {
		if ("Arbeitgeber".equals(tokenName)) {
			return ARBEITGEBER;
		} else {
			Assert.fail();
		}
		return null;
	}

	@Given("ein Arbeitgeber")
	public Arbeitgeber registriereArbeitgeber() {
		return ARBEITGEBER;
	}

	@When("dieser $Arbeitgeber registriert wurde")
	public void istEinArbeitgeber(Arbeitgeber arbeitgeber) {
		Assert.assertNotNull(arbeitgeber);
	}

	@AsParameterConverter
	public Stellenangebot erstelleStellenangebot(String tokenName) {
		if ("Stellenangebot".equals(tokenName)) {
			return STELLENANGEBOT;
		} else {
			Assert.fail();
		}
		return null;
	}
	
	@When("ein Stellenangebot erstellt hat")
	public Stellenangebot erstelleStellenangebot() {
		return STELLENANGEBOT;
	}

	@When("ein valides $Stellenangebot vorliegt")
	public void istEinStellenangebot(Stellenangebot stellenangebot) {
		Assert.assertNotNull(stellenangebot);
	}

	@When("das $Stellenangebot $anzahl Stelle zur Vermittlung bietet")
	public void setzeMaxAnzahlStellen(Stellenangebot stellenangebot,
			Integer anzahl) {
		stellenangebot.setAnzahlStellen(anzahl);
	}

	@Then("kann das $Stellenangebot noch auf $anzahl Stelle(n) vermittelt werden")
	public void vermittelbarAufStellen(Stellenangebot stellenangebot,
			Integer anzahl) {
		final Integer stellen = stellenangebot.getAnzahlStellen();
		Assert.assertEquals(anzahl, stellen);
	}
	//
	// @TextSyntax("Der Arbeitssuchende erstellt ein Stellengesuch.")
	// public Stellengesuch createStellengesuch() {
	// return new Stellengesuch();
	// }
	//
	// @TextSyntax("Es liegt ein valides #1 vor.")
	// public void istEinStellengesuch(Stellengesuch stellengesuch) {
	// Assert.assertNotNull(stellengesuch);
	// }
	//
	// @TextSyntax("Registrierung eines Arbeitssuchenden.")
	// public Arbeitssuchender registriereArbeitssuchender() {
	// return new Arbeitssuchender();
	// }
	//
	// @TextSyntax("Es liegt ein registrierter #1 vor.")
	// public void istEinArbeitssuchender(Arbeitssuchender arbeitssuchender) {
	// Assert.assertNotNull(arbeitssuchender);
	// }
	//
	//
	// /**
	// *
	// * @param arbeitssuchender
	// * @param stellenangebot
	// * @return Bewerbung
	// */
	// @TextSyntax("Der registrierte #1 erstellt zum #2 eine Bewerbung.")
	// public Bewerbung bewirbtSichAufStellenangebot(Arbeitssuchender
	// arbeitssuchender, Stellenangebot stellenangebot) {
	// return arbeitssuchender.erstelleBewerbung(stellenangebot);
	// }
	//
	// @TextSyntax("Damit liegt eine gültige Bewerbung vor.")
	// public void istEineBewerbung(Bewerbung bewerbung) {
	// Assert.assertNotNull(bewerbung);
	// }
	//
	// @TextSyntax("Der #1 wird vom #2 eingestellt und damit wird eine Stelle des #3 besetzt.")
	// public void einstellenArbeitssuchenden(Arbeitssuchender arbeitssuchender,
	// Arbeitgeber arbeitgeber, Stellenangebot stellenangebot ) {
	// stellenangebot.verringereStellenUm(1);
	// }

}
