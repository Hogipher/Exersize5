@main def main: Unit =

  check("Equal # of A's and B's") { // Passed
  """
  P = a P b | b P a | aa P bb | bb P aa | P P P | - ;
  """
  }

  check("Within a factor of 2") { // Passed
  """
  P = a P b | aa P b | a P bb | - ;
  """
  }

  check("Even a's and odd b's") { // rejects b
  """
  P = A P Bb | Bb P A ;
  B = bb | - ;
  A = aa | - ;
  """
  }

  check("Not palindromes") { // accepts ""
  """
  P = A P B | B P A | - ;
  A = aa | a ;
  B = bb | b ;
  """
  }

  check("Never be outnumbered!") { // rejects aacc
  """
  P = - | A C P | P A C | A C P A C ;
  A = a | aa ;
  C = c | - ;
  """
  }

  check("Approximate CFGs") {// accepts nivs and rej nies
  """
  CFG = n i EXP s ;
  EXP = a | v | o EXP c | OCFG ;
  OCFG = n i  EXP s | n ;
  """
  }
