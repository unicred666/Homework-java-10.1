package ru.netology.radio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {
    Radio radio = new Radio();

    @Test // проверка значения по умолчанию
    public void variableChecking() {
        Assertions.assertEquals(0, radio.getCurrentRadioStationNumber());
        Assertions.assertEquals(0, radio.getSoundVolume());
        Assertions.assertEquals(10, radio.getStationAmount());
        Assertions.assertEquals(0, radio.getMinVolume());
        Assertions.assertEquals(100, radio.getMaxVolume());
    }

    @Test // проверка установки количества радиостанций
    public void StationAmount() {
        radio.setStationAmount(30);
        Assertions.assertEquals(30, radio.getStationAmount());
    }

    @Test
    public void shouldSetRadio() { // проверка значения в пределах диапазона
        radio.setCurrentRadioStationNumber(3);

        Assertions.assertEquals(3, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void shouldNotSetMaxRadio() { // проверка значения в пределах диапазона (при выстановленом количестве радиостанций)
        Radio radio = new Radio(6);

        radio.setCurrentRadioStationNumber(3);

        Assertions.assertEquals(3, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void shouldNotSetMinRadioDefault() { // проверка значения больше диапазона (при количестве радиостанций по умолчанию)
        radio.setCurrentRadioStationNumber(-5);
        Assertions.assertEquals(0, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void souidNotSetMaxRadio() {  // проверка значения больше диапазона (при выстановленом количестве радиостанций)
        Radio radio = new Radio(4);

        radio.setCurrentRadioStationNumber(7);
        Assertions.assertEquals(0, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void souidNotSetMinRadioDefault() { // проверка значения меньше диапазона (при количестве радиостанций по умолчанию)
        radio.setCurrentRadioStationNumber(-5);
        Assertions.assertEquals(0, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void souidNotSetMinRadio() { // проверка значения меньше диапазона (при выстановленом количестве радиостанций)
        Radio radio = new Radio(4);

        radio.setCurrentRadioStationNumber(-5);

        Assertions.assertEquals(0, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void shouldSetMaxRadioDefault() { // проверка граничных значения на верхней границе диапазона (при количестве радиостанций по умолчанию)
        radio.setCurrentRadioStationNumber(9);

        Assertions.assertEquals(9, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void shouldSetMaxRadio() { // проверка граничных значения на верхней границе диапазона (при выстановленом количестве радиостанций)
        Radio radio = new Radio(34);

        radio.setCurrentRadioStationNumber(33);

        Assertions.assertEquals(33, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void souidNotSetRadioMaxDefault() { // проверка граничных значений за верхней границей диапазона (при количестве радиостанций по умолчанию)
        radio.setCurrentRadioStationNumber(10);

        Assertions.assertEquals(0, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void souidNotSetRadioMax() { // проверка граничных значений за верхней границей диапазона (при выстановленом количестве радиостанций)
        Radio radio = new Radio(3);

        radio.setCurrentRadioStationNumber(3);

        Assertions.assertEquals(0, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void shouldSetMinRadioDefault() { // проверка граничных значения на нижней границе диапазона (при количестве радиостанций по умолчанию)
        radio.setCurrentRadioStationNumber(0);

        Assertions.assertEquals(0, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void shouldSetMinRadio() { // проверка граничных значения на нижней границе диапазона (при выстановленом количестве радиостанций)
        Radio radio = new Radio(7);

        radio.setCurrentRadioStationNumber(0);

        Assertions.assertEquals(0, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void souidNotSetRadioMinDefault() { //проверка граничных значений за нижней границей диапазона (при количестве радиостанций по умолчанию)
        radio.setCurrentRadioStationNumber(-1);

        Assertions.assertEquals(0, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void souidNotSetRadioMin() { //проверка граничных значений за нижней границей диапазона (при выстановленом количестве радиостанций)
        Radio radio = new Radio(8);

        radio.setCurrentRadioStationNumber(-1);

        Assertions.assertEquals(0, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void radioNumberChangeUpDefault() { // Проверка метода NEXT изменение раиостанции на 1 вверх (значение номера радиостанции находитсяв границах диапазона) (при количестве радиостанций по умолчанию)
        radio.setCurrentRadioStationNumber(6);

        radio.next();

        Assertions.assertEquals(7, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void radioNumberChangeUp() { // Проверка метода NEXT изменение раиостанции на 1 вверх (значение номера радиостанции находитсяв границах диапазона) (при выстановленом количестве радиостанций)
        Radio radio = new Radio(8);

        radio.setCurrentRadioStationNumber(6);

        radio.next();

        Assertions.assertEquals(7, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void radioNumberChangeUpAbroadDefault() { // Проверка метода NEXT при изменение раиостанции на 1 вверх (значение номера радиостанции верхняя граница диапазона) (при количестве радиостанций по умолчанию)
        radio.setCurrentRadioStationNumber(9);

        radio.next();

        Assertions.assertEquals(0, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void radioNumberChangeUpAbroad() { // Проверка метода NEXT при изменение раиостанции на 1 вверх (значение номера радиостанции верхняя граница диапазона) (при выстановленом количестве радиостанций)
        Radio radio = new Radio(34);

        radio.setCurrentRadioStationNumber(33);

        radio.next();

        Assertions.assertEquals(0, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void radioNumberChangeDownDefault() { // Проверка метода PREV изменение раиостанции на 1 вниз (в границах диапазона) (при количестве радиостанций по умолчанию)
        radio.setCurrentRadioStationNumber(4);

        radio.prev();

        Assertions.assertEquals(3, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void radioNumberChangeDown() { // Проверка метода PREV изменение раиостанции на 1 вниз (в границах диапазона) (при количестве радиостанций по умолчанию) (при выстановленом количестве радиостанций)
        Radio radio = new Radio(7);

        radio.setCurrentRadioStationNumber(2);

        radio.prev();

        Assertions.assertEquals(1, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void radioNumberChangeDownAbroadDefault() {// Проверка метода PREV изменение раиостанции на 1 вниз за границу диапазона (при количестве радиостанций по умолчанию)
        radio.setCurrentRadioStationNumber(0);

        radio.prev();

        Assertions.assertEquals(9, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void radioNumberChangeDownAbroad() {// Проверка метода PREV изменение раиостанции на 1 вниз за границу диапазона (при выстановленом количестве радиостанций)
        Radio radio = new Radio(15);

        radio.setCurrentRadioStationNumber(0);

        radio.prev();

        Assertions.assertEquals(14, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void volumeVolumeCheck() { // проверка значения уровня громкости в пределах диапазона
        radio.setSoundVolume(77);

        Assertions.assertEquals(77, radio.getSoundVolume());
    }

    @Test
    public void volumeVolumeCheckMin() { // проверка граничного значения уровня громкости в пределах диапазона нижняя граница
        radio.setSoundVolume(1);

        Assertions.assertEquals(1, radio.getSoundVolume());
    }

    @Test
    public void volumeVolumeCheckNotMin() { // проверка граничного значения уровня громкости за пределами диапазона нижняя граница
        radio.setSoundVolume(0);

        Assertions.assertEquals(0, radio.getSoundVolume());
    }

    @Test
    public void volumeVolumeCheckMinMin() { // проверка значения уровня громкости за пределами диапазона нижняя граница
        radio.setSoundVolume(-4);

        Assertions.assertEquals(0, radio.getSoundVolume());
    }

    @Test
    public void volumeVolumeCheckMax() { // проверка значения уровня громкости в пределах диапазона вверхняя граница
        radio.setSoundVolume(99);

        Assertions.assertEquals(99, radio.getSoundVolume());
    }

    @Test
    public void volumeVolumeCheckNotMax() { // проверка граничного значения уровня громкости за пределами диапазона вверхняя граница
        radio.setSoundVolume(100);

        Assertions.assertEquals(100, radio.getSoundVolume());
    }

    @Test
    public void volumeVolumeCheckMaxMax() { // проверка значения уровня громкости за пределами диапазона вверхняя граница
        radio.setSoundVolume(160);

        Assertions.assertEquals(0, radio.getSoundVolume());
    }

    @Test
    public void shouldIncreaseCurrentVolumeMin() { // увеличение громкости на 1 при уровне громкости = 0
        radio.setSoundVolume(0);

        radio.increaseVolume();

        Assertions.assertEquals(1, radio.getSoundVolume());
    }

    @Test
    public void shouldIncreaseCurrentVolume() { // увеличение громкости на 1 при уровне громкости внутри диапазона
        radio.setSoundVolume(66);

        radio.increaseVolume();

        Assertions.assertEquals(67, radio.getSoundVolume());
    }

    @Test
    public void shouldIncreaseCurrentVolumeMax() { // увеличение громкости на 1 при уровне громкости = 99 (граничное значениие)
        radio.setSoundVolume(99);

        radio.increaseVolume();

        Assertions.assertEquals(100, radio.getSoundVolume());
    }

    @Test
    public void shouldIncreaseCurrentVolumeMax10() { // увеличение громкости на 1 при уровне громкости = 100 (граничное значениие)
        radio.setSoundVolume(100);

        radio.increaseVolume();

        Assertions.assertEquals(100, radio.getSoundVolume());
    }

    @Test
    public void shouldReduceCurrentVolumeMin() { // уменьшение громкости на 1 при уровне громкости = 0
        radio.setSoundVolume(0);

        radio.turnDownVolume();

        Assertions.assertEquals(0, radio.getSoundVolume());
    }

    @Test
    public void shouldReduceCurrentVolumeMax() { // уменьшение громкости на 1 при уровне громкости = 1 (граничное значениие)
        radio.setSoundVolume(1);

        radio.turnDownVolume();

        Assertions.assertEquals(0, radio.getSoundVolume());
    }

    @Test
    public void shouldReduceCurrentVolume() { // уменьшение громкости на 1 при уровне громкости внутри диапазона
        radio.setSoundVolume(56);

        radio.turnDownVolume();

        Assertions.assertEquals(55, radio.getSoundVolume());
    }

    @Test
    public void shouldReduceCurrentVolumeMax10() { // уменьшение громкости на 1 при уровне громкости = 100 (граничное значениие)
        radio.setSoundVolume(100);

        radio.turnDownVolume();

        Assertions.assertEquals(99, radio.getSoundVolume());
    }
}