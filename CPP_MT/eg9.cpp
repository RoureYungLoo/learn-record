
#include <iostream>
using namespace std;

constexpr long double PI=3.14159265358979323846264338327950288419716939937510582097494459230781640628;

void get_circle_info(double r,double &d,double &c,double &s ){
d=2*r;
c=PI*d;
s=PI*r*r;
}

int main(int argc, char const *argv[]) {

    double r,d,c,s;
    cin>>r;
    get_circle_info(r,d,c,s);
    cout<<d<<' '<<c<<' '<<s<<' '<<endl;
  /* code */
  return 0;
}
