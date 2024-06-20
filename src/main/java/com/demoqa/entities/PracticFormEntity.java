package com.demoqa.entities;
import lombok.*;
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PracticFormEntity {
    private String firstNameInput;
    private String lastNameInput;
    private String emailInput;
    private String mobileNumberInput;
    private String subjectsContainerInput;
    private String currentAddressInput;
    private String stateInput;
    private String cityInput;
    private String picturePath;
}
