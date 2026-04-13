#!/usr/bin/env python3

def list_demo():
    mates = ['lisi', 'zhangsan', 'wangwu']
    print(mates)
    print(mates[0])
    print(mates[1])
    print(mates[2])
    # print(mates[3]) # IndexError: list index out of range
    print(mates[-1])
    print(mates[-2])
    print(mates[-3])
    # print(mates[-4]) # IndexError: list index out of range

    mates.append('zhaoliu')
    mates.insert(1, 'guanyu')
    mates.pop(-1)
    mates[-1] = '王五'

    L = [True, 'A', {"name": 'lisi'}, [{'age': 23, 'gender': 'male'}]]
    print(L)
    print(len(L))
    print(L[3][0])
    print(len([]))

    L = [
        ['Apple', 'Google', 'Microsoft'],
        ['Java', 'Python', 'Ruby', 'PHP'],
        ['Adam', 'Bart', 'Bob']
    ]

    print(L[0][0])
    print(L[1][1])
    print(L[2][2])


def tuple_demo():
    mates = ('lisi', 'wangwu', 'zhaoliu')
    print(mates)
    print(mates[0])
    print(mates[-1])

    empty_tuple = ()
    print(empty_tuple)

    one_ele_tuple = ('ele',)
    print(one_ele_tuple)

    # 软引用
    mutable_tuple = (
        'A', "B", ['C', 'D']
    )
    print(mutable_tuple)
    mutable_tuple[2][1] = 'd'
    print(mutable_tuple)


def main():
    list_demo()
    tuple_demo()


if __name__ == '__main__':
    main()
