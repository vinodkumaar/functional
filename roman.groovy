roman_numbers = ["I": 1, "V": 5, "X": 10, "L": 50, "C": 100, "D": 500, "M": 1000]

translate = { roman_number -> 
  roman_number.inject(0) { total, roman_value -> 
      (total + roman_numbers[roman_value]) - 2 * (total % roman_numbers[roman_value])
    }
}

assert translate('MMMCM') == 3900
assert translate('MMDXIX') == 2519
