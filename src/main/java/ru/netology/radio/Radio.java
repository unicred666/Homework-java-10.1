package ru.netology.radio;

public class Radio {

    // объявляем переменные
    private int currentRadioStationNumber;
    private int soundVolume;
    private int stationAmount = 10;
    private int minVolume = 0;
    private int maxVolume = 100;

    // гетерры и сетерры
    public int getStationAmount() {
        return stationAmount;
    }

    public void setStationAmount(int stationAmount) {
        this.stationAmount = stationAmount;
    }

    public int getCurrentRadioStationNumber() {
        return currentRadioStationNumber;
    }

    public void setCurrentRadioStationNumber(int CurrentRadioStationNamber) {
        if (CurrentRadioStationNamber > (stationAmount - 1)) {
            return;
        } else if (CurrentRadioStationNamber < 0) {
            return;
        }
        this.currentRadioStationNumber = CurrentRadioStationNamber;
    }

    public int getSoundVolume() {
        return soundVolume;
    }

    public void setSoundVolume(int soundVolume) {
        if (soundVolume < minVolume) {
            soundVolume = minVolume;
        } else if (soundVolume > maxVolume) {
            soundVolume = minVolume;
        }
        this.soundVolume = soundVolume;
    }

    public int getMinVolume() {
        return minVolume;
    }

    public int getMaxVolume() {
        return maxVolume;
    }

    // конструкторы
    public Radio() {
    }

    public Radio(int stationAmount) {
        this.stationAmount = stationAmount;
    }

    // методы
    public void next() {
        if (currentRadioStationNumber < (stationAmount - 1)) {
            currentRadioStationNumber++;
        } else {
            currentRadioStationNumber = 0;
        }
    }

    public void prev() {
        if (currentRadioStationNumber > 0) {
            currentRadioStationNumber--;
        } else currentRadioStationNumber = (stationAmount - 1);
    }

    public void increaseVolume() {
        if (soundVolume < maxVolume) {
            soundVolume++;
        }
    }

    public void turnDownVolume() {
        if (soundVolume > minVolume) {
            soundVolume--;
        }
    }
}