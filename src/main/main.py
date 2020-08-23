from src.main.myMath import *


def main():
    first_num = 10
    second_num = 20

    print(f"{first_num} + {second_num} = {add(first_num, second_num)}")
    print(f"{first_num} - {second_num} = {subtract(first_num, second_num)}")
    print(f"{first_num} * {second_num} = {multiply(first_num, second_num)}")
    print(f"{first_num} / {second_num} = {divide(first_num, second_num)}")


main()
