# CITY REPORT USE CASE: Produce a set of Reports on information related to Countries

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *user* I want to *to produce reports regarding city populations in the world & different countinents/regions* so that *I can support reporting of the organisation.*

### Scope

Project.

### Level

Primary task.

### Preconditions

Database contains city population data.

### Success End Condition

A report is available for in CSV format.

### Failed End Condition

No report is produced.

### Primary Actor

Report user.

### Trigger

A request for demographic information is sent.

## MAIN SUCCESS SCENARIO

1. A request is made for a report to be generated about city information.
2. The user specifies a given region/continent & number of countries to limit the query for.
3. The user receives the report.

## EXTENSIONS

1. **Region/continent does not exist**:
    The user needs to review the possible filters for region/continent searches.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0