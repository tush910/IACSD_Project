using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using Dbinteg;

namespace Dbinteg.Controllers
{
    public class NetmeteringsController : Controller
    {
        private NetmeteringEntities db = new NetmeteringEntities();

        // GET: Netmeterings
        public ActionResult Index()
        {
            return View(db.Netmeterings.ToList());
        }

        // GET: Netmeterings/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Netmetering netmetering = db.Netmeterings.Find(id);
            if (netmetering == null)
            {
                return HttpNotFound();
            }
            return View(netmetering);
        }

        // GET: Netmeterings/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Netmeterings/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "Id,Month,MonthlyConsumption,NetConsumption,MonthlyBill,BillAfterPlan,Savings,payback")] Netmetering netmetering)
        {
            if (ModelState.IsValid)
            {
                db.Netmeterings.Add(netmetering);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(netmetering);
        }

        // GET: Netmeterings/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Netmetering netmetering = db.Netmeterings.Find(id);
            if (netmetering == null)
            {
                return HttpNotFound();
            }
            return View(netmetering);
        }

        // POST: Netmeterings/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "Id,Month,MonthlyConsumption,NetConsumption,MonthlyBill,BillAfterPlan,Savings,payback")] Netmetering netmetering)
        {
            if (ModelState.IsValid)
            {
                db.Entry(netmetering).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(netmetering);
        }

        // GET: Netmeterings/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Netmetering netmetering = db.Netmeterings.Find(id);
            if (netmetering == null)
            {
                return HttpNotFound();
            }
            return View(netmetering);
        }

        // POST: Netmeterings/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Netmetering netmetering = db.Netmeterings.Find(id);
            db.Netmeterings.Remove(netmetering);
            db.SaveChanges();
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}
