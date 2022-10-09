package ru.netology.radio;

public class Radio {

    private int currentRadioStationNumber;
    private int soundVolume;

    public int getCurrentRadioStationNumber() {
        return currentRadioStationNumber;
    }

    public void setCurrentRadioStationNumber(int CurrentRadioStationNamber) {
        if (CurrentRadioStationNamber < 0) {
            return;
        }
        if (CurrentRadioStationNamber > 9) {
            return;
        }
        this.currentRadioStationNumber = CurrentRadioStationNamber;
    }

    public void next() {
        if (currentRadioStationNumber < 9) {
            currentRadioStationNumber++;
        } else {
            currentRadioStationNumber = 0;
        }
    }

    public void prev() {
        if (currentRadioStationNumber > 0) {
            currentRadioStationNumber--;
        } else currentRadioStationNumber = 9;
    }

    public int getSoundVolume() {
        return soundVolume;
    }

    public void setSoundVolume(int newSoundVolume) {
        if (newSoundVolume > 10) {
            return;
        } else if (newSoundVolume < 0) {
            return;
        } else {
            soundVolume = newSoundVolume;
        }
    }

    public void increaseVolume() {
        if (soundVolume < 10) {
            soundVolume++;
        }
    }

    public void turnDownVolume() {
        if (soundVolume > 0) {
            soundVolume--;
        }
    }
}