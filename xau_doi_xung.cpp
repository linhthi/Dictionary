#include <iostream>
#include <stack>
#include <queue>
#include<string>
#include <fstream>
using namespace std;
bool isSymmetry(string s) {
	int n = s.length();
	stack<char> s1;
	queue<char> s2;
	for (int i=0; i<n; i++) {
		s1.push(s[i]);
		s2.push(s[i]);
	}
	while (!s1.empty()) {
		if (s1.top() != s2.front()) return false;
		s1.pop();
		s2.pop();
	}
	return true;
	}
int main () {
		string s;
		ifstream inStream;
    	inStream.open("input.txt");
    	getline(inStream, s);
    	inStream.close();
    	
    	ofstream outStream;
    	outStream.open("output.txt");
    	outStream << "Result: " << (isSymmetry(s) ?"True":"False") << endl;
    	outStream.close();
    	
    	return 0;
	}
