// The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
// For example, "ACGAATTCCG" is a DNA sequence.
// When studying DNA, it is useful to identify repeated sequences within the DNA.
// Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once 
// in a DNA molecule. You may return the answer in any order.

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASeq {
  public List<String> findRepeatedDnaSequences(String s) {
    
    Set<String> result = new HashSet<>();
    if (s.length() <= 10) return new ArrayList<String>();

    BitSet seqMap = new BitSet(20);
    int seqToken = 0;
    StringBuilder seqString = new StringBuilder(s.substring(0, 10));

    for (int i=0; i<10; i++) {
      switch(s.charAt(i)){
        case 'A':
          //seqToken |= 0;
          break;
        case 'C':
          seqToken |= 1;
          break;
        case 'G':
          seqToken |= 2;
          break;
        case 'T':
          seqToken |= 3;
          break;
      }
      seqToken <<= 2;
    }
    seqToken >>= 2;
    seqMap.set(seqToken);

    for (int i=10; i<s.length(); i++) {
      seqToken <<= 2;
      seqString.delete(0, 1);
      char curr = s.charAt(i);
      seqString.append(curr);
      switch(curr){
        case 'A':
          //seqToken |= 0;
          break;
        case 'C':
          seqToken |= 1;
          break;
        case 'G':
          seqToken |= 2;
          break;
        case 'T':
          seqToken |= 3;
          break;
      }
      seqToken &= (0xFFCFFFFF);
      
      if (!seqMap.get(seqToken)) {
        seqMap.set(seqToken);
      } else {
        result.add(seqString.toString());
      }
    }

    return new ArrayList<>(result);
  }

  public static void Run() {
    RepeatedDNASeq rd = new RepeatedDNASeq();
    System.out.println(rd.findRepeatedDnaSequences("AAAAAAAAAA"));
    System.out.println(rd.findRepeatedDnaSequences("AAAAAAAAAAA"));
    System.out.println(rd.findRepeatedDnaSequences("AAAAAAAAAAAA"));
    System.out.println(rd.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
  }
}
