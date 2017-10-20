package com.sema4.getdata.fhirparser.configuration;

public class Endpoints{
	
	private String patient;
	private String patientLabResults;
	private String patientProblems;
	private String patientVitalSigns;
	private String patientEncounters;
	public String getPatient() {
		return patient;
	}
	public void setPatient(String patient) {
		this.patient = patient;
	}
	public String getPatientLabResults() {
		return patientLabResults;
	}
	public void setPatientLabResults(String patientLabResults) {
		this.patientLabResults = patientLabResults;
	}
	public String getPatientProblems() {
		return patientProblems;
	}
	public void setPatientProblems(String patientProblems) {
		this.patientProblems = patientProblems;
	}
	public String getPatientVitalSigns() {
		return patientVitalSigns;
	}
	public void setPatientVitalSigns(String patientVitalSigns) {
		this.patientVitalSigns = patientVitalSigns;
	}
	public String getPatientEncounters() {
		return patientEncounters;
	}
	public void setPatientEncounters(String patientEncounters) {
		this.patientEncounters = patientEncounters;
	}
	
}