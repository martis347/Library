package com.library.metaphone;

public interface IMetaphoneStringHelper {
    MetaphoneString parse(String originalString);
    double compare(MetaphoneString a, MetaphoneString b);
}
