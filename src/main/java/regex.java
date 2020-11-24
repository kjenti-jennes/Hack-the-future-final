public class regex {
    RgxGen rgxGen = new RgxGen("[^0-9]*[12]?[0-9]{1,2}[^0-9]*");         // Create generator
    String s = rgxGen.generate();                                        // Generate new random value
    BigInteger estimation = rgxGen.numUnique();                          // The estimation (not accurate, see Limitations) how much unique values can be generated with that pattern.
    StringIterator uniqueStrings = rgxGen.iterateUnique();               // Iterate over unique values (not accurate, see Limitations)
    String notMatching = rgxGen.generateNotMatching();

}
}
