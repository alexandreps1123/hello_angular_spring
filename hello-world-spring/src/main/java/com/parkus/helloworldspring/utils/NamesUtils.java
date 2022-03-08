package com.parkus.helloworldspring.utils;

import java.util.Optional;

import com.parkus.helloworldspring.model.Names;

public final class NamesUtils {

    private NamesUtils() {
        throw new UnsupportedOperationException();
    }

    public static Optional<Names> toUpperName(Optional<Names> optionalName) {

        if(optionalName.isEmpty()) {
            return optionalName;
        }
        
        Names name = optionalName.get();
    
        name.setName(name.getName().toUpperCase());
    
        optionalName = Optional.of(name);

        return optionalName;
    }
}
