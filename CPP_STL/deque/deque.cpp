#include<iostream>
#include<deque>
void show(std::deque<double >items);
std::deque<double> objs2({21,22,23,24,25,26});
int main(){
    std::deque<int> objs;
    std::deque<int> objs1(5);
    // std::deque<int> objs2({21,22,23,24,25,26});
    std::deque<double> cpy_(objs2);
    std::deque<double> scores({75.2,89.5,87.2,79.6,99.5});
    // show(objs);
    // show(objs1);
    // show(objs2);
    // show(cpy_);
    // show(objs2);
    show(scores);
    std::cout<<std::endl;
    // objs2.swap(scores);
    //     show(objs2);
    // show(scores);
    return 0;

}
void show(std::deque< double>items){
    items.emplace_front(10.5);
    items.emplace_back(100.5);
    // items.emplace(items.begin()+2,100);
    // items.clear();
    // items.insert(items.begin(),222);
    // items.insert(items.end(),3,111);
    // items.insert(items.begin()+2,objs2.begin(),objs2.end());
    // items.erase(items.end()-2,items.end());
    // items.erase(items.begin()+1);
    // std::cout<<*(items.end()-2)<<std::endl;
    // items.push_back(100.5);
    // items.push_front(20.5);
    // items.pop_back();
    // items.pop_front();
    // // items.assign({1,2,3,5,7,9});
    // items.assign(6,6.5);
    // std::cout<<items.front()<<" ";
    // std::cout<<items.back()<<" ";
    for(int i=0;i<items.size();++i){
        std::cout<<items.at(i)<<" ";
    }
    // items.resize(10);
    // for(auto item:items)
    //     std::cout<<item<<" ";
    std::cout<<std::endl;
    // std::cout<<items.empty();
    // std::cout<<sizeof(items)<<std::endl;
    // items.shrink_to_fit();
    // std::cout<<sizeof(items)<<std::endl;
    // std::cout<<
    // // items.size()
    // items.max_size()
    // <<std::endl;
    // std::deque<double>::const_reverse_iterator crit;
    // crit=items.crbegin();
    // std::cout<<*crit<<std::endl;
    // crit=items.crend();
    // std::cout<<*--crit<<std::endl;
    // std::deque<double>::const_iterator cit;
    // cit=items.cbegin();
    // std::cout<<*cit<<std::endl;
    // cit=items.cend();
    // std::cout<<*--cit<<std::endl;
    // std::deque<double>::iterator it;
    // it=items.begin();
    // std::cout<<*it<<std::endl;
    // it=items.end();
    // std::cout<<*(it-1)<<std::endl;
    // std::deque<double>::reverse_iterator rit;
    // rit=items.rbegin();
    // std::cout<<*rit<<std::endl;
    // rit=items.rend();
    // std::cout<<*(rit-1)<<std::endl;

}
