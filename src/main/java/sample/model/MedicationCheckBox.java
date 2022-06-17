package sample.model;

public class MedicationCheckBox {
    private boolean isChecked = false;
    private String medicationName;
    private String dateAndAmount;

    public String getMedicationName() {
        return medicationName;
    }

    public String getDateAndAmount() {
        return dateAndAmount;
    }

    public boolean getIsChecked() {
        return isChecked;
    }
}
