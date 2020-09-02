package ru.pflb.emulator.service.impl;

import org.springframework.stereotype.Service;
import ru.pflb.emulator.model.dto.ClientDto;
import ru.pflb.emulator.service.ClientService;

import java.util.Random;

@Service
public class ClientServiceImpl implements ClientService {

    @Override
    public ClientDto getUserById(long id) {
        ClientDto client = ClientDto.builder()
                .id(id)
                .firstName(getRandomString())
                .lastName(getRandomString())
                .cardNumber(getRandomNumber(16))
                .inn(getRandomNumber(10))
                .photo(getRandomPhoto())
                .isActive(getRandomBoolean())
                .build();
        return client;
    }

    private String getRandomPhoto() {
        String result = "E:\\perflab\\java\\images\\image" + getRandomInt(1, 10) + ".jpg";
        return result;
    }

    private boolean getRandomBoolean() {
        int num = getRandomInt(0, 99);
        if (num < 50) {
            return true;
        }
        return false;
    }

    private String getRandomNumber(int numberLength) {
        StringBuilder sb = new StringBuilder(numberLength);
        for (int i = 0; i < numberLength; i++) {
            sb.append(getRandomInt(0, 9));
        }
        return sb.toString();
    }

    private String getRandomString() {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder(20);
        int stringLength = getRandomInt(3, 8);
        for (int i = 0; i < stringLength; i++) {
            char c = chars[getRandomInt(0, chars.length - 1)];
            sb.append(c);
        }
        return sb.toString();
    }

    private int getRandomInt(int min, int max) {
        Random random = new Random();
        int result = min + random.nextInt(max - min + 1);
        return result;
    }
}
