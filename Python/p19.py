def p19():
	day = 1 # 1900 starts on a Monday
	year = 1901
	num_months_sunday_starts = 0

	# Advance from 1900 to 1901
	day = day + 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + 31

	# Count the Sundays that start a month from 1901 through 2000
	while year < 2001:
		# January
		if day % 7 == 0:
			num_months_sunday_starts += 1
		day += 31

		# February
		if day % 7 == 0:
			num_months_sunday_starts += 1
 		if year != 2000 and year % 4 == 0:
			day += 29
		else:
			day += 28

		# March
		if day % 7 == 0:
			num_months_sunday_starts += 1
		day += 31

		# April
		if day % 7 == 0:
			num_months_sunday_starts += 1
		day += 30

		# May
		if day % 7 == 0:
			num_months_sunday_starts += 1
		day += 31

		# June
		if day % 7 == 0:
			num_months_sunday_starts += 1
		day += 30

		# July
		if day % 7 == 0:
			num_months_sunday_starts += 1
		day += 31

		# August
		if day % 7 == 0:
			num_months_sunday_starts += 1
		day += 31

		# September
		if day % 7 == 0:
			num_months_sunday_starts += 1
		day += 30

		# October
		if day % 7 == 0:
			num_months_sunday_starts += 1
		day += 31

		# November
		if day % 7 == 0:
			num_months_sunday_starts += 1
		day += 30

		# December
		if day % 7 == 0:
			num_months_sunday_starts += 1
		day += 31

		year += 1

	return num_months_sunday_starts

print p19()
