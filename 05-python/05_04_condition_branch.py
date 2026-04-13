#!/usr/bin/env python3

def condition_branch_demo():
    age = 20
    if age >= 18:
        print('your age is', age)

    age = 3
    if age >= 18:
        print('your age is', age)
    else:
        print('age < 18')

    age = 7
    if age >= 18:
        print('age >=18')
    elif age >= 6:
        print('6 <= age < 18')
    else:
        print('age < 6')

    if age:
        print(age)

    # age = int(input('input your age: '))
    if age >= 18:
        print(' age >= 18')
    elif age >= 6:
        print('6 <= age < 18')
    else:
        print(' age < 6')


def calc_bmi(weight, height):
    return weight / height / height


def main():
    condition_branch_demo()
    print("%.1f" % calc_bmi(80.5, 1.75))


if __name__ == '__main__':
    main()
