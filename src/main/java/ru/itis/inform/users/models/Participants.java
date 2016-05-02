package ru.itis.inform.users.models;

/**
 * Created by Moskieva on 02.05.16.
 */
public class Participants {
    private int id;
    private int documentId;
    private String fullName;
    private String education;
    private String placeOfWork;

    public Participants(int id, int documentId, String fullName, String education, String placeOfWork, String positionAtWork) {
        this.id = id;
        this.documentId = documentId;
        this.fullName = fullName;
        this.education = education;
        this.placeOfWork = placeOfWork;
        this.positionAtWork = positionAtWork;
    }

    private String positionAtWork;

    public int getId() {
            return id;
        }

    public String getFullName() {
            return fullName;
        }

    public int getDocumentId() {
            return documentId;
        }

    public String getEducation() {
            return education;
        }

    public String getPlaceOfWork() {
            return placeOfWork;
        }

    public String getPositionAtWork() {
            return positionAtWork;
        }

    public void setId(int id) {
            this.id = id;
        }

    public void setDocumentId(int documentId) {
            this.documentId = documentId;
        }

    public void setFullName(String fullName) {
            this.fullName = fullName;
        }

    public void setEducation(String education) {
            this.education = education;
        }

    public void setPlaceOfWork(String placeOfWork) {
            this.placeOfWork = placeOfWork;
        }

    public void setPositionAtWork(String positionAtWork) {
            this.positionAtWork = positionAtWork;
        }
 }
