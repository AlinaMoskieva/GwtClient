package ru.itis.inform.users.models;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Moskieva on 19.04.16.
 */
public class DocumentsDto {
    private List<DocumentDto> documents = new ArrayList<DocumentDto>();

    public List<DocumentDto> getDocuments() {
        return documents;
    }

    public DocumentsDto() {
    }

    public void setDocuments(DocumentDto document) {
        this.documents.add(document);
    }
    public  void setListDocuments(List<Document> documents){
        if (!documents.isEmpty()){
            for(int i = 0; documents.size() > i; i++){
                DocumentDto dto = new DocumentDto(documents.get(i));
                this.documents.add(dto);

            }
        }
    }
}
