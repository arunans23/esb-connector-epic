/*
 * Copyright (c) 2024, WSO2 LLC. (http://www.wso2.org).
 *
 * WSO2 LLC. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.carbon.connector.epic;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.synapse.MessageContext;
import org.wso2.carbon.connector.core.AbstractConnector;
import org.wso2.healthcare.integration.common.ehr.EHRConnectException;

public class SearchUtil extends AbstractConnector {
    private static final Log log = LogFactory.getLog(SearchUtil.class);
    public static final Map<String, String> parameterNameMap = new HashMap<String, String>() {
        {
            this.put("sourceReference", "source-reference");
            this.put("authored", "authored");
            this.put("reason", "reason");
            this.put("dataAbsentReason", "data-absent-reason");
            this.put("specialty", "specialty");
            this.put("epicGroupId", "epic-group-id");
            this.put("authoredSearchBy", "authored");
            this.put("modality", "modality");
            this.put("emptyReason", "empty-reason");
            this.put("partnerPrefix", "partner-prefix");
            this.put("periodLowerBound", "period");
            this.put("periodSearchBy", "period");
            this.put("datetimeSearchBy", "datetime");
            this.put("activityDateSearchBy", "activity-date");
            this.put("comboCode", "combo-code");
            this.put("comboValueConcept", "combo-value-concept");
            this.put("setting", "setting");
            this.put("dateLowerBound", "date");
            this.put("createdUpperBound", "created");
            this.put("valueDateUpperBound", "value-date");
            this.put("sentLowerBound", "sent");
            this.put("docstatus", "docstatus");
            this.put("requester", "requester");
            this.put("receiver", "receiver");
            this.put("verificationStatus", "verification-status");
            this.put("procedureUdi", "procedure-udi");
            this.put("targetDate", "target-date");
            this.put("ownName", "own-name");
            this.put("active", "active");
            this.put("received", "received");
            this.put("interpreter", "interpreter");
            this.put("additionalSearchParameters", "additionalSearchParameters");
            this.put("activityDateUpperBound", "activity-date");
            this.put("authoredonSearchBy", "authoredon");
            this.put("authoredonLowerBound", "authoredon");
            this.put("route", "route");
            this.put("udiCarrier", "udi-carrier");
            this.put("sender", "sender");
            this.put("birthdateUpperBound", "birthdate");
            this.put("modifiedLowerBound", "modified");
            this.put("locationPeriod", "location-period");
            this.put("achievementStatus", "achievement-status");
            this.put("device", "device");
            this.put("startDate", "start-date");
            this.put("specialArrangement", "special-arrangement");
            this.put("authoredon", "authoredon");
            this.put("birthdateSearchBy", "birthdate");
            this.put("role", "role");
            this.put("startDateLowerBound", "start-date");
            this.put("priorRequest", "prior-request");
            this.put("result", "result");
            this.put("endpoint", "endpoint");
            this.put("activityDate", "activity-date");
            this.put("issuedUpperBound", "issued");
            this.put("targetDisease", "target-disease");
            this.put("recordedDateUpperBound", "recorded-date");
            this.put("countLowerBound", "_count");
            this.put("episodeOfCare", "episode-of-care");
            this.put("abatementString", "abatement-string");
            this.put("relationship", "relationship");
            this.put("email", "email");
            this.put("authoredOn", "authored-on");
            this.put("bodysite", "bodysite");
            this.put("reaction", "reaction");
            this.put("address", "address");
            this.put("replaces", "replaces");
            this.put("docType", "doc-type");
            this.put("onsetDateUpperBound", "onset-date");
            this.put("sex", "sex");
            this.put("onlyscannable", "onlyscannable");
            this.put("started", "started");
            this.put("reporter", "reporter");
            this.put("responsibleparty", "responsibleparty");
            this.put("authoredLowerBound", "authored");
            this.put("businessStatus", "business-status");
            this.put("lotNumber", "lot-number");
            this.put("onset", "onset");
            this.put("eventDateUpperBound", "event-date");
            this.put("performerType", "performer-type");
            this.put("reactionDateUpperBound", "reaction-date");
            this.put("actor", "actor");
            this.put("intendedDispenser", "intended-dispenser");
            this.put("stage", "stage");
            this.put("occurrenceLowerBound", "occurrence");
            this.put("series", "series");
            this.put("reactionDateSearchBy", "reaction-date");
            this.put("startedUpperBound", "started");
            this.put("information", "information");
            this.put("serviceType", "service-type");
            this.put("insurance", "insurance");
            this.put("birthdateLowerBound", "birthdate");
            this.put("notes", "notes");
            this.put("evidence", "evidence");
            this.put("lifecycleStatus", "lifecycle-status");
            this.put("whenhandedoverUpperBound", "whenhandedover");
            this.put("abatementDateLowerBound", "abatement-date");
            this.put("ownPrefix", "own-prefix");
            this.put("criticality", "criticality");
            this.put("language", "language");
            this.put("source", "source");
            this.put("countUpperBound", "_count");
            this.put("clinicalStatus", "clinical-status");
            this.put("deviceName", "device-name");
            this.put("oraldiet", "oraldiet");
            this.put("serviceCategory", "service-category");
            this.put("participant", "participant");
            this.put("activityCode", "activity-code");
            this.put("statusReason", "status-reason");
            this.put("generalPractitioner", "general-practitioner");
            this.put("enterer", "enterer");
            this.put("keyword", "keyword");
            this.put("careTeam", "care-team");
            this.put("addressCity", "address-city");
            this.put("addressCountry", "address-country");
            this.put("given", "given");
            this.put("manifestation", "manifestation");
            this.put("authoredOnLowerBound", "authored-on");
            this.put("count", "_count");
            this.put("instantiatesCanonical", "instantiates-canonical");
            this.put("datetimeLowerBound", "datetime");
            this.put("whenpreparedSearchBy", "whenprepared");
            this.put("eventDateLowerBound", "event-date");
            this.put("measure", "measure");
            this.put("modifiedSearchBy", "modified");
            this.put("beneficiary", "beneficiary");
            this.put("name", "name");
            this.put("evidenceDetail", "evidence-detail");
            this.put("intendedPerformertype", "intended-performertype");
            this.put("subdetailUdi", "subdetail-udi");
            this.put("support", "support");
            this.put("eventDate", "event-date");
            this.put("operationalStatus", "operational-status");
            this.put("questionnaire", "questionnaire");
            this.put("onsetDate", "onset-date");
            this.put("reactionDate", "reaction-date");
            this.put("dateSearchBy", "date");
            this.put("destination", "destination");
            this.put("reasonReference", "reason-reference");
            this.put("eventDateSearchBy", "event-date");
            this.put("description", "description");
            this.put("careManager", "care-manager");
            this.put("medium", "medium");
            this.put("title", "title");
            this.put("conclusion", "conclusion");
            this.put("payor", "payor");
            this.put("countSearchBy", "_count");
            this.put("related", "related");
            this.put("provider", "provider");
            this.put("deathDateUpperBound", "death-date");
            this.put("scope", "scope");
            this.put("locationPeriodLowerBound", "location-period");
            this.put("onsetLowerBound", "onset");
            this.put("class", "class");
            this.put("basedOn", "based-on");
            this.put("vaccineCode", "vaccine-code");
            this.put("authoredOnSearchBy", "authored-on");
            this.put("reactionDateLowerBound", "reaction-date");
            this.put("severity", "severity");
            this.put("coverage", "coverage");
            this.put("owner", "owner");
            this.put("recorder", "recorder");
            this.put("incomingReferral", "incoming-referral");
            this.put("intendedPerformer", "intended-performer");
            this.put("componentDataAbsentReason", "component-data-absent-reason");
            this.put("substance", "substance");
            this.put("effectiveTimeLowerBound", "effective-time");
            this.put("whenpreparedUpperBound", "whenprepared");
            this.put("valueDate", "value-date");
            this.put("activityReference", "activity-reference");
            this.put("whenhandedover", "whenhandedover");
            this.put("referrer", "referrer");
            this.put("classValue", "class-value");
            this.put("startDateSearchBy", "start-date");
            this.put("targetDateLowerBound", "target-date");
            this.put("service", "service");
            this.put("recipient", "recipient");
            this.put("startDateUpperBound", "start-date");
            this.put("formula", "formula");
            this.put("location", "location");
            this.put("lastDateLowerBound", "last-date");
            this.put("family", "family");
            this.put("basedon", "basedon");
            this.put("birthdate", "birthdate");
            this.put("onsetDateSearchBy", "onset-date");
            this.put("requisition", "requisition");
            this.put("resultingcondition", "resultingcondition");
            this.put("focus", "focus");
            this.put("principalinvestigator", "principalinvestigator");
            this.put("type", "type");
            this.put("relation", "relation");
            this.put("payee", "payee");
            this.put("reasonGiven", "reason-given");
            this.put("recordedDateSearchBy", "recorded-date");
            this.put("context", "context");
            this.put("action", "action");
            this.put("authoredUpperBound", "authored");
            this.put("model", "model");
            this.put("id", "_id");
            this.put("evaluatedResource", "evaluated-resource");
            this.put("issued", "issued");
            this.put("dependent", "dependent");
            this.put("addressUse", "address-use");
            this.put("partStatus", "part-status");
            this.put("identifier", "identifier");
            this.put("occurrenceUpperBound", "occurrence");
            this.put("period", "period");
            this.put("item", "item");
            this.put("goal", "goal");
            this.put("subscriber", "subscriber");
            this.put("morphology", "morphology");
            this.put("componentCode", "component-code");
            this.put("method", "method");
            this.put("practitioner", "practitioner");
            this.put("locationPeriodUpperBound", "location-period");
            this.put("participantType", "participant-type");
            this.put("vaccineType", "vaccine-type");
            this.put("priority", "priority");
            this.put("startedLowerBound", "started");
            this.put("additive", "additive");
            this.put("deathDateSearchBy", "death-date");
            this.put("whenhandedoverLowerBound", "whenhandedover");
            this.put("phone", "phone");
            this.put("supplement", "supplement");
            this.put("onsetDateLowerBound", "onset-date");
            this.put("startedSearchBy", "started");
            this.put("valueConcept", "value-concept");
            this.put("lastDateSearchBy", "last-date");
            this.put("status", "status");
            this.put("udiDi", "udi-di");
            this.put("study", "study");
            this.put("occurrenceSearchBy", "occurrence");
            this.put("targetDateUpperBound", "target-date");
            this.put("gender", "gender");
            this.put("dateUpperBound", "date");
            this.put("issuedSearchBy", "issued");
            this.put("valueDateLowerBound", "value-date");
            this.put("occurrence", "occurrence");
            this.put("manufacturer", "manufacturer");
            this.put("whenpreparedLowerBound", "whenprepared");
            this.put("derivedFrom", "derived-from");
            this.put("telecom", "telecom");
            this.put("reasonCode", "reason-code");
            this.put("event", "event");
            this.put("authenticator", "authenticator");
            this.put("activityDateLowerBound", "activity-date");
            this.put("createdLowerBound", "created");
            this.put("performer", "performer");
            this.put("partnerName", "partner-name");
            this.put("securityLabel", "security-label");
            this.put("hasMember", "has-member");
            this.put("locationPeriodSearchBy", "location-period");
            this.put("dicomClass", "dicom-class");
            this.put("onsetUpperBound", "onset");
            this.put("bodySite", "body-site");
            this.put("disposition", "disposition");
            this.put("site", "site");
            this.put("receivedUpperBound", "received");
            this.put("prescription", "prescription");
            this.put("seriousness", "seriousness");
            this.put("organization", "organization");
            this.put("consentor", "consentor");
            this.put("effectiveTimeSearchBy", "effective-time");
            this.put("facility", "facility");
            this.put("abatementDate", "abatement-date");
            this.put("policyHolder", "policy-holder");
            this.put("date", "date");
            this.put("addressPostalcode", "address-postalcode");
            this.put("partOf", "part-of");
            this.put("instance", "instance");
            this.put("data", "data");
            this.put("itemUdi", "item-udi");
            this.put("subject", "subject");
            this.put("use", "use");
            this.put("effectiveTime", "effective-time");
            this.put("deathDateLowerBound", "death-date");
            this.put("recordedDateLowerBound", "recorded-date");
            this.put("appointment", "appointment");
            this.put("datetime", "datetime");
            this.put("protocol", "protocol");
            this.put("supportingInfo", "supporting-info");
            this.put("claim", "claim");
            this.put("modified", "modified");
            this.put("targetDateSearchBy", "target-date");
            this.put("comboDataAbsentReason", "combo-data-absent-reason");
            this.put("communication", "communication");
            this.put("lastDate", "last-date");
            this.put("appointmentType", "appointment-type");
            this.put("partof", "partof");
            this.put("issuedLowerBound", "issued");
            this.put("author", "author");
            this.put("created", "created");
            this.put("format", "format");
            this.put("receivedLowerBound", "received");
            this.put("diagnosis", "diagnosis");
            this.put("sent", "sent");
            this.put("lastDateUpperBound", "last-date");
            this.put("condition", "condition");
            this.put("asserter", "asserter");
            this.put("serviceProvider", "service-provider");
            this.put("effectiveTimeUpperBound", "effective-time");
            this.put("relatesto", "relatesto");
            this.put("sentSearchBy", "sent");
            this.put("classType", "class-type");
            this.put("request", "request");
            this.put("sponsor", "sponsor");
            this.put("code", "code");
            this.put("purpose", "purpose");
            this.put("link", "link");
            this.put("onsetInfo", "onset-info");
            this.put("slot", "slot");
            this.put("media", "media");
            this.put("detailUdi", "detail-udi");
            this.put("onsetSearchBy", "onset");
            this.put("componentValueConcept", "component-value-concept");
            this.put("legalSex", "legal-sex");
            this.put("phonetic", "phonetic");
            this.put("abatementDateUpperBound", "abatement-date");
            this.put("patient", "patient");
            this.put("periodUpperBound", "period");
            this.put("authoredOnUpperBound", "authored-on");
            this.put("specimen", "specimen");
            this.put("deathDate", "death-date");
            this.put("whenhandedoverSearchBy", "whenhandedover");
            this.put("valueDateSearchBy", "value-date");
            this.put("sentUpperBound", "sent");
            this.put("createdSearchBy", "created");
            this.put("authoredonUpperBound", "authoredon");
            this.put("abatementDateSearchBy", "abatement-date");
            this.put("resultsInterpreter", "results-interpreter");
            this.put("custodian", "custodian");
            this.put("actuality", "actuality");
            this.put("recordedDate", "recorded-date");
            this.put("receivedSearchBy", "received");
            this.put("addressState", "address-state");
            this.put("medication", "medication");
            this.put("encounter", "encounter");
            this.put("intent", "intent");
            this.put("whenprepared", "whenprepared");
            this.put("contenttype", "contenttype");
            this.put("reasonNotGiven", "reason-not-given");
            this.put("valueString", "value-string");
            this.put("modifiedUpperBound", "modified");
            this.put("category", "category");
            this.put("groupIdentifier", "group-identifier");
            this.put("account", "account");
            this.put("datetimeUpperBound", "datetime");
        }
    };

    public SearchUtil() {
    }

    public void connect(MessageContext messageContext) throws EHRConnectException {
        messageContext.setProperty("paramNameMap", parameterNameMap);
    }
}
