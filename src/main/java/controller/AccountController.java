package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Account;
import model.AccountType;
import model.State;
import service.AccountService;
import util.AutoNumberUtil;

@Controller
@RequestMapping("/account")
public class AccountController {
	@Autowired
	@Qualifier("accountService")
	AccountService accountService;

	// ---------------------------Search
	// Feature---------------------------------
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listAccount(ModelMap model, HttpServletRequest request) {
		if(request.getSession().getAttribute("manager")!=null){
			Account account = new Account();
			model.addAttribute("account", account);

			List<Account> accountList = accountService.findAllAccount();
			model.addAttribute("accounts", accountList);
			model.addAttribute("stateSearch",false);
			return "app";
		}
		return "redirect:/login";
	}
	@RequestMapping(value = {"/search" }, method = RequestMethod.GET)
	public String listSearch(ModelMap model) {
	
		return "redirect:/account/list";
	}
	@RequestMapping(value = { "/search" }, method = RequestMethod.POST)
	public String searchForm(@Valid Account account, ModelMap model, HttpServletRequest request) {
		List<Account> accounts = null;
		List<Account> listAllAccount = accountService.findAllAccount();
		String inputSearch = request.getParameter("txtSearch").toString();
		String rdNameChecked = "";
		String rdCardIdChecked = "";
		String rdAccountNumberChecked = "";
		String rdStateChecked = "";
		String rdPhoneChecked = "";
		String rdAddressChecked = "";
		String rdTypeChecked = "";

		if (request.getParameter("inputRadio") != null) {
			if (request.getParameter("inputRadio").equals("byNameInput")) {
				List<Account> listAccountByName = accountService.findByAccountName(inputSearch);
				accounts = listAccountByName != null ? listAccountByName : null;
				rdNameChecked = "checked";
				model.addAttribute("rdNameChecked", rdNameChecked);

			} else if (request.getParameter("inputRadio").equals("byIDCardInput")) {
				List<Account> listAccountByIDCard = accountService.findByIDCard(inputSearch);
				accounts = listAccountByIDCard != null ? listAccountByIDCard : null;
				rdCardIdChecked = "checked";
				model.addAttribute("rdCardIdChecked", rdCardIdChecked);
			}

			else if (request.getParameter("inputRadio").equals("byAccountNumberInput")) {
				List<Account> listAccountById = accountService.findByAccountNumber(inputSearch);
				accounts = listAccountById != null ? listAccountById : null;
				rdAccountNumberChecked = "checked";
				model.addAttribute("rdAccountNumberChecked", rdAccountNumberChecked);
			}

			else if (request.getParameter("inputRadio").equals("byStateInput")) {
				List<Account> listAccountByState = accountService.findByAccountState(inputSearch);
				accounts = listAccountByState != null ? listAccountByState : null;
				rdStateChecked = "checked";
				model.addAttribute("rdStateChecked", rdStateChecked);
			}

			else if (request.getParameter("inputRadio").equals("byAccountType")) {
				List<Account> listAccountByAccountType = accountService
						.findByAccountType(request.getParameter("txtSearch"));
				accounts = listAccountByAccountType != null ? listAccountByAccountType : null;
				rdTypeChecked = "checked";
				model.addAttribute("rdTypeChecked", rdTypeChecked);
			}

			else if (request.getParameter("inputRadio").equals("byPhoneInput")) {
				List<Account> listAccountPhoneNumber = accountService.findByAccountPhone(inputSearch);
				accounts = listAccountPhoneNumber != null ? listAccountPhoneNumber : null;
				rdPhoneChecked = "checked";
				model.addAttribute("rdPhoneChecked", rdPhoneChecked);
			} else {
				List<Account> listAccountByAddress = accountService.findByAccountArress(inputSearch);
				accounts = listAccountByAddress != null ? listAccountByAddress : null;
				rdAddressChecked = "checked";
				model.addAttribute("rdAddressChecked", rdAddressChecked);
			}
		}

		model.addAttribute("accounts", accounts);
		model.addAttribute("inputSearch", inputSearch);
		model.addAttribute("stateSearch",true);
		return "app";
	}

	// ------------------------------TAI------------------------------------------------
	@RequestMapping(value = { "/add_new_account" }, method = RequestMethod.GET)
	public String addAccount(ModelMap model, HttpServletRequest request) {
		Account account = new Account();
		model.addAttribute("account", account);
		model.addAttribute("mode", "mode_add");
		model.addAttribute("updatedAccount", false);

		AccountType[] arrayAccountType = AccountType.values();
		model.addAttribute("arrayAccountType", arrayAccountType);

		if (request.getSession().getAttribute("manager") != null) {
			return "addAccount";
		}
		return "redirect:/";
	}

	@RequestMapping(value = { "/add_new_account" }, method = RequestMethod.POST)
	public String saveNewAccount(@Valid Account newAccount, BindingResult result, HttpServletRequest request,
			ModelMap model) {

		if (result.hasErrors()) {
			return "redirect:/";
		}

		newAccount.setState(State.NEW);
		newAccount.setAccountNumber(AutoNumberUtil.autoID());
		newAccount.setCardID(AutoNumberUtil.autoCardID());

		accountService.saveAccount(newAccount);
		return "redirect:/account/list";
	}

	// ------------------------------------UPATE------------------------------------------------
	@RequestMapping(value = { "/update-{accountNumber}-account" }, method = RequestMethod.GET)
	// TEMP
	public String editAccount(@PathVariable long accountNumber, ModelMap model) {
		
		Account account = accountService.findByAccountNumber(accountNumber);
		model.addAttribute("account", account);

		AccountType[] arrayAccountType = AccountType.values();
		model.addAttribute("arrayAccountType", arrayAccountType);

		List<State> stateArrayList = new ArrayList<State>();
		System.out.println(account.getState());
		if (account.getState().equals(State.NEW)) {
			stateArrayList.clear();
			stateArrayList.add(State.NEW);
			stateArrayList.add(State.ACTIVE);
		} else if(account.getState().equals(State.ACTIVE)){
			stateArrayList.clear();
			stateArrayList.add(State.ACTIVE);
			stateArrayList.add(State.DISABLE);
		}else//(account.getState().equals(State.DISABLE))
		{
			stateArrayList.clear();
			stateArrayList.add(State.ACTIVE);
			stateArrayList.add(State.DISABLE);
			stateArrayList.add(State.REMOVABLE);
		}
		
		model.addAttribute("stateArrayList", stateArrayList);

		return "updateAccount";

	}
	
	
	
	@RequestMapping(value = { "/update-{accountNumber}-account" }, method = RequestMethod.POST)
	// TEMP
	public String updateAccount(@Valid Account account, BindingResult result, ModelMap model,
			@PathVariable long accountNumber, HttpServletRequest request) {
		if (result.hasErrors())
			return "updateAccount";
		// account.setCardID(account.getCardID());
		
		accountService.updateAccount(account);
		
		if(account.getState().equals(State.REMOVABLE))
		{
			accountService.deleteAccountById(account.getAccountNumber());
		}
		
		return "redirect:/account/list";
	}

	// logout--------------------------------------------------------------------------------------------
	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	// completed!
	public String logout(HttpServletRequest requestLoging, ModelMap model) {

		if (requestLoging.getSession().getAttribute("manager") != null) {
			requestLoging.getSession().invalidate();
			model.addAttribute("mode", "mode_index");
		}
		return "redirect:/";
	}
	
	// ------------------------------------detail------------------------------------------------
		@RequestMapping(value = { "/detail-{accountNumber}-account" }, method = RequestMethod.GET)
		// TEMP
		public String detailAccount(@PathVariable long accountNumber, ModelMap model) {
			
			Account account = accountService.findByAccountNumber(accountNumber);
			model.addAttribute("account", account);

			AccountType[] arrayAccountType = AccountType.values();
			model.addAttribute("arrayAccountType", arrayAccountType);

			List<State> stateArrayList = new ArrayList<State>();
			System.out.println(account.getState());
			if (account.getState().equals(State.NEW)) {
				stateArrayList.clear();
				stateArrayList.add(State.NEW);
				stateArrayList.add(State.ACTIVE);
			} else if(account.getState().equals(State.ACTIVE)){
				stateArrayList.clear();
				stateArrayList.add(State.ACTIVE);
				stateArrayList.add(State.DISABLE);
			}else//(account.getState().equals(State.DISABLE))
			{
				stateArrayList.clear();
				stateArrayList.add(State.ACTIVE);
				stateArrayList.add(State.DISABLE);
				stateArrayList.add(State.REMOVABLE);
			}
			
			model.addAttribute("stateArrayList", stateArrayList);

			return "updateAccount";

		}
		
		
		
		@RequestMapping(value = { "/detail-{accountNumber}-account" }, method = RequestMethod.POST)
		// TEMP
		public String detailAccount(@Valid Account account, BindingResult result, ModelMap model,
				@PathVariable long accountNumber, HttpServletRequest request) {
			if (result.hasErrors())
				return "updateAccount";
			// account.setCardID(account.getCardID());
			
			accountService.updateAccount(account);
			
			if(account.getState().equals(State.REMOVABLE))
			{
				accountService.deleteAccountById(account.getAccountNumber());
			}
			
			return "redirect:/account/list";
		}

}
