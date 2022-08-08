package co.develhope.Angelo.ServiziEmail01.api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//defines a NotificationDTO
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDTO {

    private String contactId;
    private String title;
    private String text;
}
