package com.demoqa.enums;

import lombok.Getter;

public enum SideBarMenu {

    ADMIN("Admin"),

    PIM("PIM");

    @Getter
    String menu;

    SideBarMenu (String menu) {
        this.menu = menu;
    }
}
