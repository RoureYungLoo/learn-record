#include<iostream>
using namespace std;
#include<array>

class Student{
    public:
        int id;
        double score;
    public:
        void show(){
            std::cout<<"stu id: "<<this->id<<"      stu score: "<<this->score<<std::endl;
        }
};
void test_stu();
void test_array();

int main(){
    
    // test_stu();
    test_array();
    return 0;
}
void show_array(array<double, 10>  values1,array<double, 10>  values2){
    array<double,10>::iterator it;
    cout<<"values1: {";
    for(it=values1.begin();it!=values1.end();it++){
        if (it==values1.begin()){
            cout<<*it;
        }else{
            cout<<","<<*it;
        }
    }
    cout<<"}"<<endl;

    cout<<"values2: {";
    for(it=values2.begin();it!=values2.end();it++){
        if(it==values2.begin()){
            cout<<*it;
        }else{
            cout<<","<<*it;
        }
    }
    cout<<"}"<<endl;
}
void test_array(){
    array<double,10> values{0.5,1,2,3,4};
    array<double,10> values1{0,1,2,3,4};
    array<double,10> values2{2,3,4,5,6,7};
    array<double,10>::iterator it;
    for(auto value:values){
        cout<<" "<<value;
    }
    // 交换前
    // show_array(values1,values2);
    // 交换
    // values1.swap(values2);
    // cout<<endl;
    // 交换后
    // show_array(values1,values2);

    // cout<<get<2>(values1)<<endl;
    // cout<<"交换前values1: {";
    // for(it=values1.begin();it!=values1.end();it++){
    //     if (it==values1.begin()){
    //         cout<<*it;
    //     }else{
    //         cout<<","<<*it;
    //     }
    // }
    // cout<<"}"<<endl;

    // cout<<"交换前values2: {";
    // for(it=values2.begin();it!=values2.end();it++){
    //     if(it==values2.begin()){
    //         cout<<*it;
    //     }else{
    //         cout<<","<<*it;
    //     }
    // }
    // cout<<"}"<<endl;



    // // array<double,10> values;
    // // array<double,10>::reverse_iterator it;
    
    // for(it=values1.begin();it!=values1.end();it++){
    //     cout<<"values1: "<<*it<<endl;
    // }
    // for(it=values2.begin();it!=values2.end();it++){
    //     cout<<"values2: "<<*it<<endl;
    // }
    // cout<<"values.size(): "<<values.size()<<endl;
    // cout<<"values.max_size()"<<values.max_size()<<endl;
    // cout<<values.empty()<<endl;;
    // values.empty()==1?cout<<"array 为空.\n":cout<<"array 不为空.\n";
    // values.empty()?cout<<"array 为空.\n":cout<<"array 不为空.\n";
    // // empty(); 如果array为空，返回1；如果array不为空，返回其他值
    // if(values.empty()==1){
    //     cout<<"array 为空.\n";
    // }else{
    //     cout<<"array 不为空.\n";
    // }
    // // array<double,10>::iterator it;
    // // for(it=values.begin();it!=values.end();it++){
    // //     cout<<"values: "<<*it<<endl;
    // // }
    // int i=0;
    // for(i=0;i<values.size();++i){
    //     cout<<values.at(i)<<"  ";
    //     if(i==(values.size()-1)){
    //         cout<<endl;
    //     }
    // }

 
}
void test_stu(){
    array<Student,5> students;
    array<Student,5>::iterator it;
    int id=1001;
    double score=89.15;
    Student val;
    val.id=1998001;
    val.score=78.9;
    students.fill(val);

    for(it=students.begin();it!=students.end();it++){
        // it->id=id++;
        // score+=0.35;
        // it->score=score;
        //(*it).show();//
        it->show();
    }
    // Student & first_student=students.front();
    // Student & last_student = students.back();
    // first_student.show();
    // last_student.show();
    Student * p_first_student = students.data();
    p_first_student->show();
    p_first_student++;
    p_first_student->show();
}