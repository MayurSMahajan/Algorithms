// Implementation of the bayer moore pattern searching algorithm.
// Complexity = O(nm)
// used for implementing searching substrings in long texts by skipping over
// unnecessary comparisons.

import 'dart:math' as math;

void main(List<String> args) {
  String pattern = "name";
  String text =
      "Shakespeare said what's in a and then wrote his below the quote";
  String text2 = "namenamenamenamenamenamenamenamenamenamenamenamenamename";
  String text3 =
      "Shakespeare said what's in a and then wrote his below the quote na me the quote name";

  print(boyerMoore(pattern, text));
  print(boyerMoore(pattern, text2));
  print(boyerMoore(pattern, text3));
}

List<int> boyerMoore(String pattern, String text) {
  int m = pattern.length;
  int n = text.length;

  List<int> badChar = List.filled(256, -1);
  List<int> matches = [];

  //filling the badChar table.
  for (var i = 0; i < pattern.length; i++) {
    badChar[pattern.codeUnitAt(i)] = i;
  }

  int s = 0;

  while (s <= (n - m)) {
    int j = m - 1;

    while (j >= 0 && pattern[j] == text[s + j]) {
      j--;
    }

    //if pattern is present at current shift, the index will become -1
    if (j < 0) {
      matches.add(s);
      s += (s + m < n) ? m - badChar[text[s + m].codeUnitAt(0)] : 1;
    } else {
      s += math.max(1, j - badChar[text[s + j].codeUnitAt(0)]);
    }
  }

  return matches;
}
