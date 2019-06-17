using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Security;
using Login_Report.Models;
using PagedList.Mvc;
using PagedList;

namespace Login_Report.Controllers
{
    public class UserController : Controller
    {
        String emailToCheck = "";

        [HttpGet]
        public ActionResult Registration()
        {  
            return View();
        }

        [HttpPost]
        public ActionResult Registration(Users user)
        {
            try
            {
                using (MyDatabaseEntities dc = new MyDatabaseEntities())
                {
                    dc.Users.Add(user);
                    dc.SaveChanges();
                }
                ModelState.Clear();
                ViewBag.SuccessMessage = "Registration successful.";
                //return View("Login", new Users());
                return RedirectToAction("Login", "User");
            }
            catch
            {
                return View("Registration");
            }
        }




        //Login
        [HttpGet]
        public ActionResult Login()
        {
            return View();
        }


        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Login(UserLogin login)
        {
            string message = "";
            using (MyDatabaseEntities dc = new MyDatabaseEntities())
            {
                var v = dc.Users.Where(a => a.EmailID == login.EmailID).FirstOrDefault();
                if (v != null)
                {
                    if (v.Password.Equals(login.Password))
                    {
                      //  user.Date = DateTime.Now;
                      //  dc.Users.Add(user);
                      //  dc.SaveChanges();
 
                      //  Session["email"] = login.EmailID;
                      //  emailToCheck = login.EmailID.ToString();
                        return RedirectToAction("Index", "User");
                    }
                    else
                    {
                        message = "Invalid credential provided";
                    }
                }
                else
                {
                    message = "Invalid credential provided";
                }
            }
            ViewBag.Message = message;
            return View();
        }


        //logout
        [HttpPost]
        public ActionResult Logout()
        {
            return RedirectToAction("Login", "User");
        }


        MyDatabaseEntities dc = new MyDatabaseEntities();


        public ActionResult Index(int? i)
        {
            List<Users> userlist = dc.Users.ToList();
            return View(userlist.ToPagedList(i ?? 1, 4));
        }


        public ActionResult Delete(int id = 0)
        {
            return View(dc.Users.Find(id));
        }

        [HttpPost, ActionName("Delete")]
        public ActionResult DeleteUser(int id, Users user)
        {
            try
            {
                user = dc.Users.Find(id);
                dc.Users.Remove(user);
                dc.SaveChanges();
                return RedirectToAction("Index");
                //var item2 = dc.Users.Where(x => x.UserID == id).ToList();
               // return View("Delete", item2);
            }
            catch
            {
                return View();
            }
            
        }


    }
}
