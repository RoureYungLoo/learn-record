class Student:
    def __init__(self):
        pass

    def __fun1(self):  # 私有
        pass

    def __fun2__(self):
        print("__fun2__")

    def _fun3(self):
        print("_fun3")

    def _fun4_(self):
        print("_fun4_")


if __name__ == "__main__":
    print(__name__)

    stu = Student()
    # stu.__fun1()
    stu.__fun2__()
    stu._fun3()
    stu._fun4_()
