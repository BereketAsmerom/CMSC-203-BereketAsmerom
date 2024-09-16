/*
 * Class: CMSC140 CRN 34518
 * Instructor: Professor Fouche
 * Project: Classwork 3
 * Description: grade average program
 * Due Date: 03/07/24
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Bereket Asmerom
*/

#include <iostream>
#include <string>
#include <iomanip>
using namespace std;

int main() {

    string fullName;
    double syllabusQuiz, chapter1Quiz, chapter2Quiz, classwork1, classwork2;

    cout << "Enter your full name (first and last name): ";
    getline(cin, fullName);

    cout << "Enter the score for Syllabus Quiz (0-100): ";
    cin >> syllabusQuiz;

    cout << "Enter the score for Chapter 1 Quiz (0-100): ";
    cin >> chapter1Quiz;

    cout << "Enter the score for Chapter 2 Quiz (0-100): ";
    cin >> chapter2Quiz;

    cout << "Enter the score for Programming Classwork 1 (0-100): ";
    cin >> classwork1;

    cout << "Enter the score for Programming Classwork 2 (0-100): ";
    cin >> classwork2;

    double totalScore = syllabusQuiz + chapter1Quiz + chapter2Quiz + classwork1 + classwork2;
    double averageScore = totalScore / 5;

    cout << "\nFull Name: " << fullName << endl;
    cout << "Total Score: " << double(totalScore) << endl;
    cout << fixed << setprecision(2) << "Average Score: " << averageScore << endl;

    return 0;
}
