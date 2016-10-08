# For column x, row y:
# First child is [x + 1, y]
# Second child is [x + 1, y + 1]

import time

sample_triangle = [
	[3],
	[7, 4],
	[2, 4, 6],
	[8, 5, 9, 3]
]

p18_triangle = [
	[75],
	[95, 64],
	[17, 47, 82],
	[18, 35, 87, 10],
	[20, 04, 82, 47, 65],
	[19, 01, 23, 75, 03, 34],
	[88, 02, 77, 73, 07, 63, 67],
	[99, 65, 04, 28, 06, 16, 70, 92],
	[41, 41, 26, 56, 83, 40, 80, 70, 33],
	[41, 48, 72, 33, 47, 32, 37, 16, 94, 29],
	[53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14],
	[70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57],
	[91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48],
	[63, 66, 04, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31],
	[04, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 04, 23]
]

def zero_triangle(rows):
	triangle = []
	for i in range(0, rows):
		triangle.append([0] * (i + 1))
	return triangle

def calc_max(x, y, triangle):
	this_val = triangle[x][y]

	if x >= len(triangle) - 1:
		return this_val

	left_val = this_val + calc_max(x + 1, y, triangle)
	right_val = this_val + calc_max(x + 1, y + 1, triangle)

	return max(left_val, right_val)

def calc_max_op(x, y, triangle, known_values):
	this_val = known_values[x][y]

	if this_val != 0:
		return this_val

	this_val = triangle[x][y]

	if x >= len(triangle) - 1:
		known_values[x][y] = this_val
		return this_val

	left_val = this_val + calc_max_op(x + 1, y, triangle, known_values)
	right_val = this_val + calc_max_op(x + 1, y + 1, triangle, known_values)
	this_val = max(left_val, right_val)

	known_values[x][y] = this_val
	return this_val

def p18(triangle):
	known_values = zero_triangle(len(triangle))

	start_time = time.time()
	max_path = calc_max(0, 0, triangle)
	unop_duration = time.time() - start_time
	print("Unoptimized time: {:0.5f}".format(unop_duration))
	print("Max path sum: {0}".format(max_path))

	start_time = time.time()
	max_path = calc_max_op(0, 0, triangle, known_values)
	op_duration = time.time() - start_time
	print("Optimized time: {:0.5f}".format(op_duration))
	print("Max path sum: {0}".format(max_path))

	print("{:0.5f}x difference".format(unop_duration / op_duration))

p18(p18_triangle)
