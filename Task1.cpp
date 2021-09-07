#include <stdlib.h>
#include <iostream>
#include <string>
#include <mysql/mysql.h>

#include <cppconn/driver.h>
#include <cppconn/exception.h>
#include <cppconn/resultset.h>
#include <cppconn/statement.h>

using namespace std;

#define HOST "tcp://in03.bya.ac:3306"
#define USER "u143_V8d54d6jFy"
#define PASS "a.X.lLMvRyNw.3o=G.WjZK47"

class Task1
{

public:
    void Dashboard(int value)
    {
        try
        {
            sql::Driver *driver;
            sql::Connection *con;
            sql::Statement *stmt;
            sql::ResultSet *res;
            driver = get_driver_instance();
            con = driver->connect(HOST, USER, PASS);
            switch (value)
            {
            //HOD Dashboard
            case 1:
            {
                string Dept;
                cout << "Enter Department Name\n";
                cin >> Dept;

                con->setSchema(Dept);

                stmt = con->createStatement();

                //Run Query
                // SELECT * FROM 'DEPT' WHERE DEPT.Advisor = name;
                // Print
                string query = "SELECT * FROM Results";

                res = stmt->executeQuery(query);
                cout << "Student ID  Subject ID  Marks\n";
                while (res->next())
                {
                    /* Access column fata by numeric offset, 1 is the first column */
                    cout << res->getString(1) << "              " << res->getString(2) << "         " << res->getString(3) << endl;
                }

                break;
            }
            // Advisor Dashboard
            case 2:
            {
                string id, dept;
                cout << "Enter Faculty ID\n";
                cin >> id;
                cout << "Enter Department Name\n";
                cin >> dept;

                //Run Query
                // SELECT * FROM 'DEPT' WHERE DEPT.Advisor = name;
                // Print

                con->setSchema(dept);

                stmt = con->createStatement();

                string query = "SELECT * FROM Results INNER JOIN Students ON `Subjects.Subject ID` = `Results.Subject ID` WHERE `Class ID`=" + id;
                cout << query << endl;

                res = stmt->executeQuery(query);
                cout << "Student ID  Subject ID  Marks\n";
                while (res->next())
                {
                    /* Access column fata by numeric offset, 1 is the first column */
                    cout << res->getString(1) << "              " << res->getString(2) << "         " << res->getString(3) << endl;
                }
            }
            // Faculty Dashboard
            case 3:
            {
                string id, dept;
                cout << "Enter Faculty ID\n";
                cin >> id;
                cout << "Enter Department Name\n";
                cin >> dept;

                //Run Query
                // SELECT * FROM 'DEPT' WHERE DEPT.Faculty = name;
                // Print

                con->setSchema(dept);

                stmt = con->createStatement();

                string query = "SELECT * FROM Results INNER JOIN Subjects ON `Subjects.Subject ID` = `Results.Subject ID` WHERE `Faculty ID`=" + id;
                cout << query << endl;

                res = stmt->executeQuery(query);
                cout << "Student ID  Subject ID  Marks\n";
                while (res->next())
                {
                    /* Access column fata by numeric offset, 1 is the first column */
                    cout << res->getString(1) << "              " << res->getString(2) << "         " << res->getString(3) << endl;
                }
            }
            //Student Dashboard
            case 4:
            {
                string id, dept;
                cout << "Enter Student ID\n";
                cin >> id;
                cout << "Enter Department Name\n";
                cin >> dept;

                con->setSchema(dept);

                stmt = con->createStatement();

                string query = "SELECT * FROM Results WHERE `Student ID`=" + id;

                res = stmt->executeQuery(query);
                cout << "Student ID  Subject ID  Marks\n";
                while (res->next())
                {
                    /* Access column fata by numeric offset, 1 is the first column */
                    cout << res->getString(1) << "              " << res->getString(2) << "         " << res->getString(3) << endl;
                }
            }
            }
        }
        catch (sql::SQLException &e)
        {
                if(e.getErrorCode() == 0)
                {
                    cout<<"Executed Successfully!\n";
                }else
                {
                cout << "# ERR: " << e.what();
                cout << " (MySQL error code: " << e.getErrorCode();
                cout << ", SQLState: " << e.getSQLState() << " )" << endl;
                }
        }
    }
    void getInput()
    {

        cout << "Enter the user\n";
        cout << "1. Admin\n";
        cout << "2. HOD\n";
        cout << "3. Advisor\n";
        cout << "4. Faculty\n";
        cout << "5. Student\n";
        int N;
        cin >> N;
        switch (N)
        {
        //Admin
        case 1:
        {
            cout << "Case 1\n";
            adminDashboard();
            getInput();
            break;
        }
        case 2:
        {
            cout << "Case 2\n";
            Dashboard(1);
            getInput();
            break;
        }
        case 3:
        {
            cout << "Case 3\n";
            Dashboard(2);
            getInput();
            break;
        }
        case 4:
        {
            cout << "Case 4\n";
            Dashboard(3);
            getInput();
            break;
        }
        case 5:
        {
            cout << "Case 5\n";
            Dashboard(4);
            getInput();
            break;
        }
        default:
        {
            cout << "Incorrect details\n";
            getInput();
            break;
        }
        }
    }

    void adminDashboard()
    {

        //MySQL Driver Init
        sql::Driver *driver;
        sql::Connection *con;
        sql::Statement *stmt;
        sql::ResultSet *res;
        driver = get_driver_instance();
        con = driver->connect(HOST, USER, PASS);

        //Fetch Data
        string name, dept;
        cout << "Enter Student ID\n";
        cin >> name;
        cout << "Enter Department Name\n";
        cin >> dept;

        cout << "Actions that can be performed\n";
        cout << "1. Enter Student Marks\n";
        cout << "2. View Student Marks\n";
        int ID;
        cin >> ID;

        switch (ID)
        {
        case 1:
        {
            string subject, faculty, marks;
            cout << "Enter Subject ID\n";
            cin >> subject;
            cout << "Enter Mark\n";
            cin >> marks;
            cout << "Enter Faculty ID\n";
            cin >> faculty;

            try
            {

                con->setSchema("s143_test");

                stmt = con->createStatement();

                string query = "INSERT INTO Results (`Student ID`,`Subject ID`,`Mark`,`Faculty ID`) VALUES ('" + name + "','" + subject + "','" + marks + "','" + faculty + "');";

                res = stmt->executeQuery(query);
            }
            catch (sql::SQLException &e)
            {
                if(e.getErrorCode() == 0)
                {
                    cout<<"Executed Successfully!\n";
                }else
                {
                cout << "# ERR: " << e.what();
                cout << " (MySQL error code: " << e.getErrorCode();
                cout << ", SQLState: " << e.getSQLState() << " )" << endl;
                }
            }
            break;
        }
        case 2:
        {
            try
            {
                driver = get_driver_instance();
                con = driver->connect("tcp://in03.bya.ac:3306", "u143_V8d54d6jFy", "a.X.lLMvRyNw.3o=G.WjZK47");
                con->setSchema("s143_test");

                stmt = con->createStatement();

                string query = "SELECT * FROM Results WHERE `Student ID` = " + name;

                res = stmt->executeQuery(query);
                cout << "Student ID  Subject ID  Marks\n";
                while (res->next())
                {
                    /* Access column fata by numeric offset, 1 is the first column */
                    cout << res->getString(1) << "              " << res->getString(2) << "         " << res->getString(3) << endl;
                }
            }
            catch (sql::SQLException &e)
            {
                if(e.getErrorCode() == 0)
                {
                    cout<<"Executed Successfully!\n";
                }else
                {
                cout << "# ERR: " << e.what();
                cout << " (MySQL error code: " << e.getErrorCode();
                cout << ", SQLState: " << e.getSQLState() << " )" << endl;
                }
            }
            break;
        }
        default:
        {
            cout << "Incorrect Option Selected\n";
            break;
        }
        }
    }
};

int main()
{
    Task1 task;
    task.getInput();
    return 0;
}