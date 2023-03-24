#include<iostream>
#include<vector>
using namespace std;

int main(int argc, char const *argv[])
{
    vector<int> child_hungry_degree({1,2});
    vector<int> cookies({1,2,3});
    int kid=0;
    int cookie=0;
    while(kid<child_hungry_degree.size()&&cookie<cookies.size()){
	if(cookies.at(cookie)>=child_hungry_degree.at(kid)) {
		kid++;
		cookie++;
	}
    }
    cout<<"有"<<kid<<"个孩子可以吃饱"<<endl;
    // std::vector<int> nums({1,2,3,4,5});
    // int target=11;
    //    int i,j,k;
    //     int sum=0;
    //     int length=0;
    //     for(i=0;i<nums.size();++i){//最多第i+1轮
    //         for(j=0; j < nums.size()-i; j++){//j为起始下标
    //             sum=0;//每个连续子数组元素相加前置零
    //             for(k=j; k<=i+j; k++){//连续子数组下标范围
    //                 sum+=nums.at(k);
                    
    //             }
    //             std::cout<<" sum :"<<sum<<" ";
    //             if(sum>=target){
    //                 length=i+1;
    //                 std::cout<<"length: "<<length<<" "; 
    //                 exit(0);
    //             }
    //         }
    //         std::cout<<std::endl;
    //     }
    // std::vector<double> values({1,3,5});
    // std::vector<double> ages({21,22,23});
    // values.insert(values.begin(),333);
    // values.insert(values.end(),3,111);
    // values.insert(values.end(),ages.begin(),ages.end());
    // values.erase((values.begin()+2));
    // // values.clear();
    //     // values.swap(ages);
    // values.emplace((values.begin()+2),99);
    // values.emplace_back(1001);
    // for (auto value : values ){
    //         std::cout<<value<<" ";
    // }
    // std::cout<<std::endl;
    // for(auto age:ages){
    //     std::cout<<age<<" ";
    // }
    // std::cout<<std::endl;
    // values.swap(ages);

    // values.reserve(5);
    // values.resize(5);
    // std::cout<<"values.size(): "<<values.size()<< std::endl;
    // std::cout<<"values.capacity(): "<<values.capacity()<< std::endl;

    // std::vector<int> grade(100,60);
    // int num;
    // float value=1.0;
    // std::vector<float> price(num,value);
    // values.reserve(15);

    // std::vector<double> primes{3,5,7,9,11,13,15};

    // primes.assign({34,25,98});
    // primes.assign(3,15.5);
    // primes.push_back(99);
    // primes.pop_back();
    // std::cout<<primes[5]<<std::endl;
    // std::cout<<primes[5]<<std::endl;
    // std::cout<<primes.front()<<std::endl;
    // std::cout<<primes.back()<<std::endl;
    // std::cout<<*primes.data()<<std::endl;


    // auto r_it_prime=primes.rbegin();
    // primes.resize(8);
    // for (  r_it_prime = primes.rbegin(); r_it_prime != primes.rend(); r_it_prime++)
    // {
            // std::cout<<*r_it_prime<<" ";
    // }
    // std::cout<<std::endl<<primes.size();
    
    // std::cout<<std::endl<<primes.size();
    // std::cout<<std::endl<<primes.capacity();
    // std::cout<<std::endl<<primes.empty();
    // primes.reserve(10);

    //  std::cout<<std::endl<<primes.capacity();
    // std::cout<<std::endl<<primes.max_size();
    // std::cout<<std::endl<<sizeof (primes);
    // primes.shrink_to_fit();
    // std::cout<<std::endl<<sizeof (primes);


        
        // std::vector<double>::iterator it_prime;
    // for (it_prime  = primes.begin(); it_prime != primes.end(); it_prime++)
    // {
    //     std::cout<<*it_prime<<" ";
    // }
    



    return 0;
}
