package com.example.coursems.utils;

import com.example.coursems.cmd.ConstException;
import com.example.coursems.exception.InvalidIdException;

import java.util.Date;
import java.util.UUID;

public class UUIDUtil {

    public static UUID validateUUID(String uuid) {
        try {
            return UUID.fromString(uuid);
        } catch (Exception e) {
            throw new InvalidIdException(ConstException.UUID_INVALID,uuid);
        }
    }


}
