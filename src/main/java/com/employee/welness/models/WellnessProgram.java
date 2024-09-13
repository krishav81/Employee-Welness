package com.employee.welness.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "wellness_programs")
public class WellnessProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wellnessProgramID;

    @Column(nullable = false)
    private String wellnessProgramName;

    @Column(nullable = false)
    private String wellnessProgramStartDate;

    @Column(nullable = false)
    private String wellnessProgramEndDate;

    @Column(nullable = false)
    private String category;

    private String description;

 
   @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WellnessProgramStatus wellnessProgramStatus;
   
   public enum WellnessProgramStatus {
       COMPLETED, PENDING, ONGOING
   }
   
   
  
    
    public Long getWellnessProgramID() {
		return wellnessProgramID;
	}



	public void setWellnessProgramID(Long wellnessProgramID) {
		this.wellnessProgramID = wellnessProgramID;
	}



	public String getWellnessProgramName() {
		return wellnessProgramName;
	}



	public void setWellnessProgramName(String wellnessProgramName) {
		this.wellnessProgramName = wellnessProgramName;
	}



	public String getWellnessProgramStartDate() {
		return wellnessProgramStartDate;
	}



	public void setWellnessProgramStartDate(String wellnessProgramStartDate) {
		this.wellnessProgramStartDate = wellnessProgramStartDate;
	}



	public String getWellnessProgramEndDate() {
		return wellnessProgramEndDate;
	}



	public void setWellnessProgramEndDate(String wellnessProgramEndDate) {
		this.wellnessProgramEndDate = wellnessProgramEndDate;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}






	public WellnessProgramStatus getWellnessProgramStatus() {
		return wellnessProgramStatus;
	}



	public void setWellnessProgramStatus(WellnessProgramStatus wellnessProgramStatus) {
		this.wellnessProgramStatus = wellnessProgramStatus;
	}



	public WellnessProgram(Long wellnessProgramID, String wellnessProgramName, String wellnessProgramStartDate,
			String wellnessProgramEndDate, String category, String description, Employee createdBy,
			WellnessProgramStatus wellnessProgramStatus) {
		super();
		this.wellnessProgramID = wellnessProgramID;
		this.wellnessProgramName = wellnessProgramName;
		this.wellnessProgramStartDate = wellnessProgramStartDate;
		this.wellnessProgramEndDate = wellnessProgramEndDate;
		this.category = category;
		this.description = description;
		
		this.wellnessProgramStatus = wellnessProgramStatus;
	}



	public WellnessProgram() {
		super();
		
	}
	



	@Override
	public String toString() {
		return "WellnessProgram [wellnessProgramID=" + wellnessProgramID + ", wellnessProgramName="
				+ wellnessProgramName + ", wellnessProgramStartDate=" + wellnessProgramStartDate
				+ ", wellnessProgramEndDate=" + wellnessProgramEndDate + ", category=" + category + ", description="
				+ description + ", createdBy="  + ", wellnessProgramStatus=" + wellnessProgramStatus + "]";
	}




	
}
