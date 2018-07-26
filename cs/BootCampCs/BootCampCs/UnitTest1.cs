using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;



namespace BootCampCs
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void LogginIn()
        {

            var driver = new ChromeDriver();
            driver.Manage().Window.Maximize();
            driver.Navigate().GoToUrl("https://techblog.polteq.com/testshop/index.php");

            IWebElement loginText = driver.FindElement(By.ClassName("login"));
            loginText.Click();

            IWebElement userName = driver.FindElement(By.Id("email"));
            userName.SendKeys("tom.huismans@polteq.com");

            IWebElement password = driver.FindElement(By.Id("passwd"));
            password.SendKeys("tomtomtom");

            IWebElement loginButton = driver.FindElement(By.Name("SubmitLogin"));
            loginButton.Click();

            IWebElement AccountName = driver.FindElement(By.ClassName("account"));
            Assert.AreEqual("Tom tom", AccountName.Text);
            driver.Quit();
        }
    }
}
